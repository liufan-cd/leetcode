package person.liufan.leetcode.thousand.hundred.two.fifth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.two.fifth
 * @description:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/24
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        System.out.println(reverseKGroup.reverseKGroup(
                reverseKGroup.toListNode(
                        new int[]{1,2,3,4,5}), 1));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        /*if (k == 1) {
            return head;
        }*/
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode index = preHead;
        while ((index = reverse(index, k)) != null) {
        }
        return preHead.next;
    }

    public ListNode reverse(ListNode preHead, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode index = preHead;
        for (int i = 0; i < k; i++) {
            if (index.next != null) {
                index = index.next;
                nodes[i] = index;
            } else {
                return null;
            }
        }
        nodes[0].next = nodes[k - 1].next;
        nodes[k - 1].next = null;
        preHead.next = nodes[k - 1];
        index = preHead;
        for (int i = k - 1; i >= 0; i--) {
            index.next = nodes[i];
            index = index.next;
        }
        return nodes[0];
    }

    public ListNode toListNode(int[] ints) {
        ListNode head = new ListNode();
        ListNode pre = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode end = new ListNode();
            end.val = ints[i];
            if (null == pre) {
                pre = head = end;
            } else {
                pre.next = end;
                pre = end;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString() {
        return null == next ? String.valueOf(val) : val + next.toString();
    }
}
