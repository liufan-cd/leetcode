package person.liufan.leetcode.thousand.hundred.ninth.ninth;

import person.liufan.common.TreeNode;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.ninth
 * @description: TODO
 * @date 2021/4/12
 */
public class RecoverTree {
    public static void main(String[] args) {
        RecoverTree recoverTree = new RecoverTree();
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null),
                null);
        treeNode.printTree();
        recoverTree.recoverTree(treeNode);
        treeNode.printTree();
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        boolean isRollBack = false;
        all:
        while (true) {
            while (!isRollBack && root.left != null) {
                stack.push(root);
                root = root.left;
            }
            if (preNode != null) {
                if (preNode.val > root.val) {
                    if (firstNode == null) {
                        firstNode = preNode;
                        secondNode = root;
                    } else {
                        secondNode = root;
                        break all;
                    }
                }
            }
            preNode = root;
            if (root.right != null) {
                root = root.right;
                isRollBack = false;
            } else {
                if (stack.size() == 0) {
                    break all;
                }
                root = stack.pop();
                isRollBack = true;
            }
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
