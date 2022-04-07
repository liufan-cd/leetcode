package person.liufan.leetcode.zero.zero.nine.tenth;

import person.liufan.common.TreeNode;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.tenth
 * @description:
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @date 2021/4/12
 */
public class IsSameTree {
    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        //TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        //TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree.isSameTree(null, p));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Stack<TreeNode> pRoot = new Stack<>();
        Stack<TreeNode> qRoot = new Stack<>();
        boolean isRollBack = false;
        all:
        while (true) {
            while (!isRollBack && p.left != null) {
                if (q.left == null) {
                    return false;
                } else {
                    pRoot.push(p);
                    qRoot.push(q);
                    p = p.left;
                    q = q.left;
                }
            }
            if (p.left == null && q.left != null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            if (p.right != null) {
                if (q.right == null) {
                    return false;
                }
                p = p.right;
                q = q.right;
                isRollBack = false;
            } else {
                if (q.right != null) {
                    return false;
                }
                if (pRoot.size() == 0) {
                    if (qRoot.size() != 0) {
                        return false;
                    }
                    break all;
                }
                if (qRoot.size() == 0) {
                    return false;
                }
                p = pRoot.pop();
                q = qRoot.pop();
                isRollBack = true;
            }
        }
        return true;
    }
}
