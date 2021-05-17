package person.liufan.offer.thirtytwo;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtytwo
 * @description:
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @date 2021/5/17
 */
public class LevelOrder3 {
    public static void main(String[] args) {
        LevelOrder3 levelOrder3 = new LevelOrder3();
        System.out.println(levelOrder3.levelOrder(TreeUtils.deserialize("3,9,20,null,null,15,7")));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0, true);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, int layer, boolean isRight) {
        if (root == null) {
            return;
        }
        if (ans.size() == layer) {
            ans.add(new LinkedList<>());
        }
        LinkedList layerNums = (LinkedList) ans.get(layer);
        if (isRight) {
            layerNums.addLast(root.val);
        } else {
            layerNums.addFirst(root.val);
        }
        dfs(root.left, ans, layer + 1, !isRight);
        dfs(root.right, ans, layer + 1, !isRight);
    }
}
