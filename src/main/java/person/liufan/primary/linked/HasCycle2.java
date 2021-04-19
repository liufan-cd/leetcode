package person.liufan.primary.linked;

import person.liufan.common.ListNode;

import java.util.HashSet;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.linked
 * @description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/15
 */
public class HasCycle2 {
    public static void main(String[] args) {
        ListNode end = new ListNode(4);
        ListNode param = new ListNode(3, new ListNode(2, new ListNode(0, end)));
        //end.next = param.next;
        HasCycle2 hasCycle = new HasCycle2();
        System.out.println(hasCycle.hasCycle(param));
    }
    public boolean hasCycle(ListNode head) {
        ListNode low,fast;
        fast = head;
        low = head;
        boolean flag = false;
        while (fast != null) {
            fast = fast.next;
            if (flag) {
                low = low.next;
                flag = false;
            } else {
                flag = true;
            }
            if (low == fast) {
                return true;
            }
        }
        return false;
    }
}
