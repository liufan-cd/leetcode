package person.liufan.offer.twentyeight;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentyeight
 * @description:
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @date 2021/5/16
 */
public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(TreeUtils.deserialize("1,2,2,3,4,4,3")));
        System.out.println(isSymmetric.isSymmetric(TreeUtils.deserialize("1,2,2,null,3,null,3")));
    }
    public boolean isSymmetric(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
