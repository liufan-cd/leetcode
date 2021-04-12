package person.liufan.leetcode.two.third;

import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.two.third
 * @description:
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @date 2021/3/24
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = mergeTwoLists(node, lists[i]);
        }
        return node;
    }
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
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}