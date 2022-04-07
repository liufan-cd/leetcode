package person.liufan.leetcode.zero.eight.nine.seven;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.eight.nine.seven
 * @description: TODO
 * @date 2021/4/25
 */
public class IncreasingBST {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserialize("5,3,6,2,4,null,8,1,null,null,null,7,9");
        IncreasingBST increasingBST = new IncreasingBST();
        increasingBST.increasingBST(root).printTree();
    }
    public TreeNode increasingBST(TreeNode root) {
        pre = temp;
        dfs(root);
        return pre.right;
    }

    TreeNode pre,temp = new TreeNode();
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        dfs(root.right);
    }
}
