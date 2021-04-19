package person.liufan.primary.tree;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.tree
 * @description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @date 2021/4/15
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode param = new TreeNode(1
                , new TreeNode(2, new TreeNode(4), new TreeNode(4))
                , new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(param));
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            boolean ll = dfs(left.left, right.right);
            boolean lr = dfs(left.right, right.left);
            return ll && lr;
        } else {
            return false;
        }
    }
}
