package person.liufan.middle.tree;

import person.liufan.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.tree
 * @description: TODO
 * @date 2021/4/16
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        TreeNode param = new TreeNode(3
                , new TreeNode(9)
                , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(param));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (layer % 2 != 0) {
                result.get(layer).add(0, root.val);
            } else {
                result.get(layer).add(root.val);
            }

        }
        layer++;
        dfs(root.left);
        dfs(root.right);
        layer--;
    }
}
