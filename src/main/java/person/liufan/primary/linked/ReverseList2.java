package person.liufan.primary.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.linked
 * @description: 反转一个单链表。
 * @date 2021/4/14
 */
public class ReverseList2 {
    public static void main(String[] args) {
        ReverseList2 reverseList = new ReverseList2();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseList.reverseList(listNode));
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        return preHead;
    }

    ListNode preHead;
    public ListNode dfs(ListNode head) {
        if (head.next == null) {
            this.preHead = head;
        } else {
            ListNode temp = head.next;
            head.next = null;
            dfs(temp).next = head;
        }
        return head;
    }
}
