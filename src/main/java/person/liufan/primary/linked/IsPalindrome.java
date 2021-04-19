package person.liufan.primary.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.linked
 * @description: 请判断一个链表是否为回文链表。
 * @date 2021/4/14
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        //ListNode param = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        //ListNode param = new ListNode(1, new ListNode(2, new ListNode(1)));
        //ListNode param = new ListNode(1);
        System.out.println(isPalindrome.isPalindrome(null));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = null;
        ListNode preHead = head;
        boolean flag = false;
        while (head != null) {
            head = head.next;
            if (flag) {
                mid = preHead;
                preHead = preHead.next;
                flag = false;
            } else {
                flag = true;
            }
        }
        return true;
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
