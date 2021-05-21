package person.liufan.offer.fiftyfive;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyfive
 * @description:
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @date 2021/5/21
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode param = TreeUtils.deserialize("1,2,2,3,3,null,null,4,4").printTree();
        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced(param));
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    boolean ans = true;
    public int dfs(TreeNode root) {
        if (!ans) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int leftDeep = dfs(root.left);
        int rightDeep = dfs(root.right);
        int max = Math.max(leftDeep, rightDeep);
        if (max - leftDeep > 1 || max - rightDeep > 1) {
            ans = false;
        }
        return max + 1;
    }
}
