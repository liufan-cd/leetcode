package person.liufan.leetcode.thousand.hundred.ninth.fifth;

import person.liufan.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.fifth
 * @description:
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * @date 2021/4/9
 */
public class GenerateTrees2 {
    public static void main(String[] args) {
        GenerateTrees2 generateTrees = new GenerateTrees2();
        List<TreeNode> treeNodes = generateTrees.generateTrees(3);
        for (TreeNode node : treeNodes) {
            node.printTree();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> listNode = new LinkedList<>();
        if (start > end) {
            listNode.add(null);
            return listNode;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i, leftNode, rightNode);
                    listNode.add(root);
                }
            }
        }
        return listNode;
    }
}
