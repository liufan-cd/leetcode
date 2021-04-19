package person.liufan.primary.linked;

import person.liufan.common.ListNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.linked
 * @description:
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * @date 2021/4/14
 */
public class DeleteNode {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
