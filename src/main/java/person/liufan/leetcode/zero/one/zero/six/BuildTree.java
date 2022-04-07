package person.liufan.leetcode.zero.one.zero.six;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.zero.six
 * @description:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @date 2021/5/14
 */
public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{
                9,3,15,20,7
        },new int[]{
                9,15,7,20,3
        }).printTree();
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int leftLength = 0;
        while (inorder[inLeft + leftLength] != rootVal) {
            leftLength++;
        }
        root.left = buildTree(inorder, postorder, inLeft, inLeft + leftLength - 1, postLeft, postLeft + leftLength - 1);
        root.right = buildTree(inorder, postorder, inLeft + leftLength + 1, inRight, postLeft + leftLength, postRight - 1);
        return root;
    }
}
