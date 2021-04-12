package person.liufan.leetcode.six.first;


import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.six.first
 * @description:
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @date 2021/4/6
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(0,
                new ListNode(1,
                        new ListNode(2)));
        RotateRight rotateRight = new RotateRight();
        System.out.println(rotateRight.rotateRight(null, 0));
        System.out.println(rotateRight.rotateRight(new ListNode(1), 5));
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        int n = 0;
        while (pre.next != null) {
            n++;
            pre = pre.next;
        }
        if (n == 0) {
            return null;
        }
        pre.next = preHead.next;
        int i = 0;
        k = k % n;
        pre = preHead;
        while (pre != null && pre.next != null) {
            if (n - i == k) {
                preHead.next = pre.next;
                pre.next = null;
                pre = preHead.next;
            }
            pre = pre.next;
            i++;
        }
        return preHead.next;
    }
}
