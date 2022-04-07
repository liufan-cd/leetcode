package person.liufan.leetcode.zero.zero.two.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.two.first
 * @description:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @date 2021/3/24
 */
public class MergeTwoLists2 {
    public static void main(String[] args) {
        MergeTwoLists2 mergeTwoLists2 = new MergeTwoLists2();
        System.out.println(mergeTwoLists2.mergeTwoLists(mergeTwoLists2.toListNode(new int[]{1, 2, 4}),
                mergeTwoLists2.toListNode(new int[]{1, 3, 4})));
    }

    /**
     * 递归调用本身
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode pre = null;
        ListNode end = null;
        while (l1 != null && l2 != null) {
            end = new ListNode();
            if (l1.val <= l2.val) {
                end.val = l1.val;
                l1 = l1.next;
            } else {
                end.val = l2.val;
                l2 = l2.next;
            }
            if (pre == null) {
                pre = end = head;
            }
            pre.next = end;
            pre = end;
        }
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return head;
    }

    /**
     * 递归调用
     * @param end
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeOne(ListNode end, ListNode l1, ListNode l2) {
        return null;
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
