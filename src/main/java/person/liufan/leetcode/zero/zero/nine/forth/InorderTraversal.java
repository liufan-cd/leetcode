package person.liufan.leetcode.zero.zero.nine.forth;


import person.liufan.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.forth
 * @description:
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 * @date 2021/4/9
 */
public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        //TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        /*TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),null);*/
        TreeNode treeNode = new TreeNode(1,null,
                new TreeNode(2,null,new TreeNode(3,null,new TreeNode(4,new TreeNode(5),null))));
        System.out.println(treeNode.getMaxDeep());
        treeNode.printTree();
        //System.out.println(inorderTraversal.inorderTraversal(treeNode));
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            result.add(root.val);
            dfs(root.right);
        }
    }
}
