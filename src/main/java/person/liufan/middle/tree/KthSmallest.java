package person.liufan.middle.tree;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.tree
 * @description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @date 2021/4/19
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode param = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(param, 4));
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }
    boolean isFind = false;
    int now = 0;
    int k;
    int result;
    public void dfs(TreeNode root) {
        if (isFind || root == null) {
            return;
        }
        dfs(root.left);
        now++;
        if (now == k) {
            isFind = true;
            result = root.val;
        }
        dfs(root.right);
    }
}
