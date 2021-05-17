package person.liufan.offer.thirtytwo;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtytwo
 * @description:
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @date 2021/5/17
 */
public class LevelOrder2 {
    public static void main(String[] args) {
        LevelOrder2 levelOrder2 = new LevelOrder2();
        System.out.println(levelOrder2.levelOrder(TreeUtils.deserialize("3,9,20,null,null,15,7")));
    }
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
