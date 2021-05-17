package person.liufan.leetcode.thousand.one.zero.two;

import person.liufan.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.zero.two
 * @description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @date 2021/5/17
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, int layer) {
        if (root == null) {
            return;
        }
        if (ans.size() == layer) {
            ans.add(new ArrayList<>());
        }
        ans.get(layer).add(root.val);
        dfs(root.left, ans, layer + 1);
        dfs(root.right, ans, layer + 1);
    }
}
