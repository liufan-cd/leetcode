package person.liufan.leetcode.thousand.hundred.ninth.second;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.second
 * @description:
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/9
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode param = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        System.out.println(reverseBetween.reverseBetween(param, 2, 3));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //寻找到翻转节点的头结点
        ListNode preHead = new ListNode(0, head);
        for (int i = 0; i < left - 1; i++) {
            preHead = preHead.next;
        }
        ListNode reHead = preHead.next;
        ListNode end = reHead;
        ListNode next = reHead.next;
        ListNode pre = null;
        for (int i = left; i <= right; i++) {
            reHead.next = pre;
            pre = reHead;
            reHead = next;
            if (next != null) {
                next = next.next;
            }
        }
        preHead.next = pre;
        end.next = reHead;
        return left == 1 ? preHead.next : head;
    }
}
