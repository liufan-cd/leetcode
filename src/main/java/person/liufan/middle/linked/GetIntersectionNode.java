package person.liufan.middle.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.linked
 * @description: TODO
 * @date 2021/4/16
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode third = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode first = new ListNode(4, new ListNode(1,third));
        ListNode second = new ListNode(5, new ListNode(0, new ListNode(1, third)));
        System.out.println(getIntersectionNode.getIntersectionNode(first, second));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int sizeA = 0;
        int sizeB = 0;
        ListNode preA = new ListNode(0, headA);
        ListNode preB = new ListNode(0, headB);
        while (headA != null) {
            headA = headA.next;
            sizeA++;
        }
        while (headB != null) {
            headB = headB.next;
            sizeB++;
        }
        headA = preA.next;
        headB = preB.next;
        if (sizeA > sizeB) {
            while (sizeA > sizeB) {
                headA = headA.next;
                sizeA--;
            }
        } else if (sizeA < sizeB) {
            while (sizeA < sizeB) {
                headB = headB.next;
                sizeB--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
