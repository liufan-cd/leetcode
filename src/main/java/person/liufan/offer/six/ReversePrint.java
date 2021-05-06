package person.liufan.offer.six;

import person.liufan.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.six
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @date 2021/5/6
 */
public class ReversePrint {
    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(n - i - 1);
        }
        return ans;
    }
}
