package person.liufan.leetcode.thousand.hundred.ninth.enghth;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.enghth
 * @description: TODO
 * @date 2021/4/12
 */
public class IsValidBST {
    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        //TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        //TreeNode treeNode = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        //TreeNode treeNode = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(-2, null, new TreeNode(-1));
        System.out.println(isValidBST.isValidBST(treeNode));
    }
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return result;
    }
    int pre;
    boolean flag = true;
    boolean result = true;
    public void dfs(TreeNode root) {
        if (result && root != null) {
            dfs(root.left);
            if (flag) {
                pre = root.val;
                flag = false;
            } else if (result) {
                if (root.val <= pre) {
                    result = false;
                } else {
                    pre = root.val;
                }
            }
            dfs(root.right);
        }
    }
}
