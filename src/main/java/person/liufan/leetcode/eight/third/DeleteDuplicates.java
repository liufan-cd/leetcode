package person.liufan.leetcode.eight.third;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.eight.third
 * @description:
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * @date 2021/4/8
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5)))))));
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        //System.out.println(deleteDuplicates.deleteDuplicates(head));
        System.out.println(deleteDuplicates.deleteDuplicates(null));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        ListNode now = head;
        while (now != null) {
            if (now.next != null && now.val == now.next.val) {
                now = now.next;
                continue;
            }
            pre.next = now;
            pre = pre.next;
            now = now.next;
            pre.next = null;
        }
        return preHead.next;
    }
}
