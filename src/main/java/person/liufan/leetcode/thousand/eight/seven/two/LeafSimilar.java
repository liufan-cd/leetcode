package person.liufan.leetcode.thousand.eight.seven.two;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.eight.seven.two
 * @description: 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * @date 2021/5/10
 */
public class LeafSimilar {
    public static void main(String[] args) {
        LeafSimilar leafSimilar = new LeafSimilar();
        System.out.println(leafSimilar.leafSimilar(TreeUtils.deserialize("3,5,1,6,2,9,8,null,null,7,4")
                , TreeUtils.deserialize("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8")));
        /*System.out.println(leafSimilar.leafSimilar(TreeUtils.deserialize("1")
                , TreeUtils.deserialize("2")));*/
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(new ArrayList<>(), root2).equals(dfs(new ArrayList<>(), root1));
    }
    private List<Integer> dfs(List<Integer> list,TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(list, root.left);
        dfs(list, root.right);
        return list;
    }
}
