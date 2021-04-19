package person.liufan.primary.tree;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.tree
 * @description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @date 2021/4/15
 */
public class MaxDepth {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        getDeep(root, 1);
        return maxDeep;
    }
    int maxDeep = 0;
    private void getDeep(TreeNode root,int deep) {
        if (root != null) {
            maxDeep = Math.max(deep, maxDeep);
            getDeep(root.left, deep + 1);
            getDeep(root.right, deep + 1);
        }
    }
}
