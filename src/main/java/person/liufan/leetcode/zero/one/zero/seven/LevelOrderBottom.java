package person.liufan.leetcode.zero.one.zero.seven;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.zero.seven
 * @description: 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @date 2021/5/14
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        System.out.println(levelOrderBottom.levelOrderBottom(TreeUtils.deserialize("3,9,20,null,null,15,7")));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root);
        Collections.reverse(ans);
        return ans;
    }

    int layer = -1;
    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        layer++;
        List<Integer> layerVal;
        if (layer == ans.size()) {
            layerVal = new ArrayList<>();
            ans.add(layerVal);
        } else {
            layerVal = ans.get(layer);
        }
        dfs(root.left);
        layerVal.add(root.val);
        dfs(root.right);
        layer--;
    }
}
