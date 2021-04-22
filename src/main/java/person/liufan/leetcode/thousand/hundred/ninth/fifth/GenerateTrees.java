package person.liufan.leetcode.thousand.hundred.ninth.fifth;

import person.liufan.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.fifth
 * @description:
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * @date 2021/4/9
 */
public class GenerateTrees {
    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> treeNodes = generateTrees.generateTrees(3);
        for (TreeNode root : treeNodes) {
            root.printTree();
        }
    }

    boolean[] isUsed;
    int n;
    List<Integer> combine = new ArrayList<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        this.isUsed = new boolean[n + 1];
        this.n = n;
        dfs();
        return result;
    }

    public void dfs() {
        if (combine.size() == n) {
            result.add(toTree());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) {
                continue;
            }
            combine.add(i);
            isUsed[i] = true;
            dfs();
            combine.remove(combine.size() - 1);
            isUsed[i] = false;
        }
    }
    public TreeNode toTree() {
        TreeNode root = new TreeNode(combine.get(0));
        TreeNode parent = root;
        for (int i = 1; i < n; i++) {
            Integer integer = combine.get(i);
            while (true) {
                TreeNode left = parent.left;
                TreeNode right = parent.right;
                if (integer < parent.val) {
                    if (left == null) {
                        parent.left = new TreeNode(integer);
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (right == null) {
                        parent.right = new TreeNode(integer);
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return root;
    }
}
