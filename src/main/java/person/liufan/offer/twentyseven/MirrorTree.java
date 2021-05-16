package person.liufan.offer.twentyseven;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentyseven
 * @description:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @date 2021/5/16
 */
public class MirrorTree {
    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.mirrorTree(TreeUtils.deserialize("4,2,7,1,3,6,9")).printTree();
    }
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
