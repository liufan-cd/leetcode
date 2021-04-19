package person.liufan.primary.tree;

import person.liufan.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.tree
 * @description: 二叉树的层序遍历
 * @date 2021/4/15
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode param = new TreeNode(3
                , new TreeNode(9)
                , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(param));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    int layer = 0;
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (layer == result.size()) {
            List<Integer> layerNumbers = new ArrayList<>();
            layerNumbers.add(root.val);
            result.add(layerNumbers);
        } else {
            result.get(layer).add(root.val);
        }
        layer++;
        dfs(root.left);
        dfs(root.right);
        layer--;
    }
}
