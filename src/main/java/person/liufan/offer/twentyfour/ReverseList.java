package person.liufan.offer.twentyfour;

import person.liufan.common.ListNode;
import person.liufan.common.ListNodeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentyfour
 * @description:
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @date 2021/5/16
 */
public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        System.out.println(reverseList.reverseList(ListNodeUtils.build(new int[]{1,2,3,4,5})));
    }
    public ListNode reverseList(ListNode head) {
        preHead = new ListNode();
        dfs(head).next = null;
        return preHead.next;
    }

    ListNode preHead;
    private ListNode dfs(ListNode head) {
        if (head == null) {
            return preHead;
        }
        ListNode reverse = dfs(head.next);
        reverse.next = head;
        return head;
    }
}
