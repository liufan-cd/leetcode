package person.liufan.leetcode.one.ninth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.ninth
 * @description: TODO
 * @date 2021/3/23
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode();
            pre.val = i;
            if (i != 5) {
                pre.next = node;
                pre = node;
            }
        }
        System.out.println(removeNthFromEnd.removeNthFromEnd(head, 5));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] listNodes = new ListNode[30];
        int size = 1;
        ListNode temp = head;
        while (null != temp.next) {
            listNodes[size - 1] = temp;
            temp = temp.next;
            size++;
        }
        listNodes[size - 1] = temp;
        if (size - n == 0) {
            return head.next;
        }
        listNodes[size - n - 1].next = listNodes[size - n + 1];
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
        return null != next ? val + next.toString() : String.valueOf(val);
    }
}
