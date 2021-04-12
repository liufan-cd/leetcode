package person.liufan.leetcode.zero.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero
 * @description:
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.getNode();
        ListNode l2 = addTwoNumbers.getNode2();
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2));
    }

    public ListNode getNode() {
        ListNode l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)))))));
        return l1;
    }
    public ListNode getNode2() {
        ListNode l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9))));
        return l1;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Map temp = sum(l1, l2,false);
        ListNode firstNode = new ListNode((int)temp.get("sum"));
        ListNode tempNode = l1;
        ListNode tempNode2 = l2;
        ListNode result = firstNode;
        while (tempNode.next != null && tempNode2.next != null) {
            tempNode = tempNode.next;
            tempNode2 = tempNode2.next;
            temp = sum(tempNode, tempNode2, (boolean) temp.get("flag"));
            result.next = new ListNode((int) temp.get("sum"));
            result = result.next;
        }
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            temp = sum(tempNode, new ListNode(0), (boolean) temp.get("flag"));
            result.next = new ListNode((int) temp.get("sum"));
            result = result.next;
        }
        while (tempNode2.next != null) {
            tempNode2 = tempNode2.next;
            temp = sum(new ListNode(0), tempNode2, (boolean) temp.get("flag"));
            result.next = new ListNode((int)temp.get("sum"));
            result = result.next;
        }
        if ((boolean) temp.get("flag")) {
            result.next = new ListNode(1);
        }
        return firstNode;
    }

    public Map sum(ListNode l1, ListNode l2,boolean flag) {
        HashMap<Object, Object> map = new HashMap<>();
        int sum = 0;
        if (flag) {
            sum = l1.val + l2.val + 1;
        }else {
            sum = l1.val + l2.val;
        }
        if (sum >= 10) {
            map.put("sum", sum - 10);
            map.put("flag", true);
            return map;
        } else {
            map.put("sum", sum);
            map.put("flag", false);
            return map;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "++" + next.toString();
            }
            return ""+val;
        }
    }
}
