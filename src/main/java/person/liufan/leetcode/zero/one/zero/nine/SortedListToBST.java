package person.liufan.leetcode.zero.one.zero.nine;

import person.liufan.common.ListNode;
import person.liufan.common.ListNodeUtils;
import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.zero.nine
 * @description:
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/14
 */
public class SortedListToBST {
    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        sortedListToBST.sortedListToBST(ListNodeUtils.build(new int[]{-10, -3, 0, 5, 9})).printTree();
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return dfs(head, size);
    }

    public TreeNode dfs(ListNode head, int length) {
        if (head == null || length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(head.val);
        }
        int mid = length >>> 1;
        ListNode midNode = head;
        int temp = mid;
        while (midNode != null && temp != 0) {
            midNode = midNode.next;
            temp--;
        }
        if (midNode == null) {
            return null;
        }
        TreeNode root = new TreeNode(midNode.val);
        root.left = dfs(head, mid);
        root.right = dfs(midNode.next, length - mid - 1);
        return root;
    }
}
