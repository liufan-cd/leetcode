package person.liufan.leetcode.eight.sixth;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.eight.sixth
 * @description:
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/8
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        /*ListNode head = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2 ))))));*/
        ListNode head = new ListNode(3,new ListNode(1));
        System.out.println(partition.partition(head, 3));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(-1, head);
        ListNode maxHead = new ListNode();
        ListNode current = head;
        ListNode minCurrent = minHead;
        ListNode maxCurrent = maxHead;
        while (current != null) {
            if (current.val < x) {
                minCurrent.next = current;
                current = current.next;
                minCurrent = minCurrent.next;
                minCurrent.next = null;
            } else {
                maxCurrent.next = current;
                current = current.next;
                maxCurrent = maxCurrent.next;
                maxCurrent.next = null;
            }
        }
        minCurrent.next = maxHead.next;
        return minHead.next;
    }
}
