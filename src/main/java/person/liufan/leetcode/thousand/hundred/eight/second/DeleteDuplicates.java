package person.liufan.leetcode.thousand.hundred.eight.second;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.second
 * @description:
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/8
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4
                                                        *//*new ListNode(5)*//*))))));*/
        ListNode head = new ListNode(1);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(head));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        ListNode now = head;
        boolean flag = false;
        int preNum = -1;
        while (now != null) {
            if (flag && now.val == preNum) {
                now = now.next;
                pre.next = null;
                continue;
            }else {
                flag = false;
            }
            if (now.next != null && now.val == now.next.val) {
                flag = true;
                preNum = now.val;
                now = now.next;
                pre.next = null;
                continue;
            }
            pre.next = now;
            pre = pre.next;
            now = now.next;
            pre.next = null;
        }
        return preHead.next;
    }
}
