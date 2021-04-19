package person.liufan.primary.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.linked
 * @description: 反转一个单链表。
 * @date 2021/4/14
 */
public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseList.reverseList(listNode));
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
}
