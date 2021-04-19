package person.liufan.middle.linked;

import person.liufan.common.ListNode;

import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.linked
 * @description: TODO
 * @date 2021/4/16
 */
public class OddEvenList {
    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        //ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3)));
        System.out.println(oddEvenList.oddEvenList(listNode));
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode first = new ListNode();
        ListNode firstHead = first;
        ListNode second = new ListNode();
        ListNode secondHead = second;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                first.next = head;
                first = first.next;
                flag = false;
            } else {
                second.next = head;
                second = second.next;
                flag = true;
            }
            head = head.next;
            first.next = null;
            second.next = null;
        }
        first.next = secondHead.next;
        return firstHead.next;
    }
}
