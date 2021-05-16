package person.liufan.offer.twentyfive;

import person.liufan.common.ListNode;
import person.liufan.common.ListNodeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentyfive
 * @description: 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @date 2021/5/16
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode param1 = ListNodeUtils.build(new int[]{1, 2, 4});
        ListNode param2 = ListNodeUtils.build(new int[]{1, 3, 4});
        System.out.println(mergeTwoLists.mergeTwoLists(param1, param2));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        dfs(l1, l2, pre);
        return pre.next;
    }
    public void dfs(ListNode l1, ListNode l2,ListNode pre) {
        if (l1 == null) {
            pre.next = l2;
            return;
        }
        if (l2 == null) {
            pre.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            pre.next = l1;
            dfs(l1.next, l2, pre.next);
        } else {
            pre.next = l2;
            dfs(l1, l2.next, pre.next);
        }
    }
}
