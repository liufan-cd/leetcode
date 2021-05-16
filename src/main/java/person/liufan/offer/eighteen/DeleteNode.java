package person.liufan.offer.eighteen;

import person.liufan.common.ListNode;
import person.liufan.common.ListNodeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.eighteen
 * @description:
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * @date 2021/5/16
 */
public class DeleteNode {
    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        System.out.println(deleteNode.deleteNode(ListNodeUtils.build(new int[]{4, 5, 1, 9}), 4));
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode preHead = new ListNode(0, head);
        ListNode preTemp = preHead;
        while (head != null) {
            if (head.val == val) {
                preTemp.next = head.next;
                break;
            } else {
                preTemp = head;
                head = head.next;
            }
        }
        return preHead.next;
    }
}
