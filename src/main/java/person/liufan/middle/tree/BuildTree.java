package person.liufan.middle.tree;

import person.liufan.common.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.tree
 * @description: TODO
 * @date 2021/4/16
 */
public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).printTree();
    }
    int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int from, int end, int left, int right) {
        if (from > end || left > right) {
            return null;
        }
        if (from == preorder.length) {
            return null;
        }
        int rootVal = preorder[from];
        TreeNode root = new TreeNode(rootVal);
        //i为左子数长度
        int i = left;
        for (; i <= right; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }
        int length = i - left;
        //
        TreeNode leftTree = buildTree(from + 1, from + length, left, left + length - 1);
        TreeNode rightTree = buildTree(from + 1 + length, end, left + length + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

}
