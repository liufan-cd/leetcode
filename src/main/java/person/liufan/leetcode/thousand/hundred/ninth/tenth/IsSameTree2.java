package person.liufan.leetcode.thousand.hundred.ninth.tenth;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.tenth
 * @description:
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @date 2021/4/12
 */
public class IsSameTree2 {
    public static void main(String[] args) {
        IsSameTree2 isSameTree = new IsSameTree2();
        /*//TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        //TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, null, new TreeNode(2));*/
        System.out.println(isSameTree.isSameTree(null, null));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
