package person.liufan.leetcode.zero.zero.zero.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
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
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers = new AddTwoNumbers2();
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
        //判断是否进位
        boolean flag = false;
        int sum = l1.val + l2.val;
        //创建头结点
        ListNode first = new ListNode(sum % 10);
        //创建尾结点
        ListNode result = first;
        //指定默认的空节点
        ListNode emptyNode = new ListNode(0);
        //当两条节点中任意一个有下一个节点都要进行计算
        while (l1.next != null || l2.next != null) {
            //对没有的节点赋默认值0,存在的节点移动指向
            if (l1.next == null) {
                l1 = emptyNode;
            }else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                l2 = emptyNode;
            } else {
                l2 = l2.next;
            }
            //判断上一次的和是否大于10，是否需要进位
            if (sum >= 10) {
                sum = l1.val + l2.val + 1;
            } else {
                sum = l1.val + l2.val;
            }
            //创建下一个返回节点
            result.next = new ListNode(sum % 10);
            //移动指向
            result = result.next;
        }
        //判断最后一次是否需要进位
        if (sum >= 10) {
            result.next = new ListNode(1);
        }
        return first;
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
