package person.liufan.middle.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.linked
 * @description: TODO
 * @date 2021/4/16
 */
public class GetIntersectionNode2 {
    public static void main(String[] args) {
        GetIntersectionNode2 getIntersectionNode = new GetIntersectionNode2();
        //ListNode third = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode third = new ListNode(3);
        //ListNode first = new ListNode(4, new ListNode(1,third));
        ListNode first = new ListNode(4, new ListNode(1,third));
        //ListNode second = new ListNode(5, new ListNode(0, new ListNode(1, third)));
        ListNode second = new ListNode(2, third);
        System.out.println(getIntersectionNode.getIntersectionNode(third, second));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode preA = new ListNode(0, headA);
        ListNode preB = new ListNode(0, headB);
        while (headA != headB) {
            if (headA == null) {
                headA = preB.next;
            }else {
                headA = headA.next;
            }
            if (headB == null) {
                headB = preA.next;
            } else {
                headB = headB.next;
            }
        }
        return headA;
    }
}
