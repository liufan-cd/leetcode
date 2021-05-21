package person.liufan.offer.fiftyfour;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyfour
 * @description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @date 2021/5/21
 */
public class KthLargest {
    public static void main(String[] args) {

    }
    public int kthLargest(TreeNode root, int k) {
        index = 0;
        dfs(root, k);
        return ans;
    }

    int index;
    int ans;
    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (index > k) {
            return;
        }
        dfs(root.right, k);
        index++;
        if (index == k) {
            ans = root.val;
        }
        dfs(root.left, k);
    }
}
