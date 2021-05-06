package person.liufan.offer.seven;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.seven
 * @description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @date 2021/5/6
 */
public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{1,2}, new int[]{2,1}).printTree();
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        // 相等返回，其实可以继续递归，可以不用判断的，没必要
        if (preL == preR) {
            return new TreeNode(preorder[preL]);
        }
        // 越界返回空
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        // 循环获取左子树长度
        int i = inL;
        for (; i <= inR; i++) {
            if (inorder[i] == preorder[preL]) {
                break;
            }
        }
        int left = i - inL;
        // 递归调用构建左子树
        root.left = buildTree(preorder, inorder, preL + 1, preL + left, inL, inL + left - 1);
        // 递归调用构建右子树
        root.right = buildTree(preorder, inorder, preL + left + 1, preR, inL + left + 1, inR);
        return root;
    }
}
