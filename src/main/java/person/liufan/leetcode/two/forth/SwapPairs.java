package person.liufan.leetcode.two.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.two.forth
 * @description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @date 2021/3/24
 */
public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        System.out.println(swapPairs.swapPairs(swapPairs.toListNode(new int[]{1, 2, 3, 4})));
    }
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode index = preHead;
        preHead.next = head;
        while ((index = changeTwo(index)) != null) {
        }
        return preHead.next;
    }

    public ListNode changeTwo(ListNode pre) {
        ListNode one = pre.next;
        if (one == null) {
            return null;
        }
        ListNode two = one.next;
        if (two == null) {
            return one;
        }
        ListNode end = two.next;
        one.next = end;
        two.next = null;
        pre.next = two;
        two.next = one;
        return one;
    }
    public ListNode toListNode(int[] ints) {
        ListNode head = new ListNode();
        ListNode pre = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode end = new ListNode();
            end.val = ints[i];
            if (null == pre) {
                pre = head = end;
            } else {
                pre.next = end;
                pre = end;
            }
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
    @Override
    public String toString() {
        return null == next ? String.valueOf(val) : val + next.toString();
    }
}
