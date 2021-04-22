package person.liufan.advanced.linked;

import person.liufan.common.ListNode;

import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.linked
 * @description: TODO
 * @date 2021/4/22
 */
public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode param = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        /*ListNode param = new ListNode(-1
                , new ListNode(5
                , new ListNode(3
                , new ListNode(4
                , new ListNode(0)))));*/
        System.out.println(sortList.sortList(param));
    }
    public ListNode sortList(ListNode head) {
        ListNode[] sort = sort(head);
        return sort == null ? null : sort[0];
    }
    public ListNode[] sort(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode compare = head;
        ListNode left = new ListNode(), right = new ListNode();
        ListNode preLeft = left;
        ListNode preRight = right;
        head = head.next;
        while (head != null) {
            if (head.val <= compare.val) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = null;
        right.next = null;
        ListNode[] result = new ListNode[2];
        ListNode[] sortLeft = sort(preLeft.next);
        if (sortLeft == null) {
            result[0] = compare;
        } else {
            result[0] = sortLeft[0];
            sortLeft[1].next = compare;
        }
        ListNode[] sortRight = sort(preRight.next);
        if (sortRight == null) {
            result[1] = compare;
            compare.next = null;
        } else {
            result[1] = sortRight[1];
            compare.next = sortRight[0];
            sortRight[1].next = null;
        }
        return result;
    }
}
