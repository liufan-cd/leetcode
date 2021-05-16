package person.liufan.offer.twentytwo;

import person.liufan.common.ListNode;
import person.liufan.common.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentytwo
 * @description:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/16
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        System.out.println(getKthFromEnd.getKthFromEnd(ListNodeUtils.build(new int[]{1,2,3,4,5}), 5));
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int index = 0;
        while (index < size - k) {
            head = head.next;
            index++;
        }
        return head;
    }
}
