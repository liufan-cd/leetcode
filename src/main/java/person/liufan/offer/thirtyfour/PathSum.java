package person.liufan.offer.thirtyfour;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtyfour
 * @description:
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @date 2021/5/17
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(TreeUtils.deserialize("5,4,8,11,null,13,4,7,2,null,null,5,1"), 22));
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, new ArrayList<>(), target);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> combine, int target) {
        if (root != null && root.val == target && root.left == null && root.right == null) {
            combine.add(root.val);
            ans.add(new ArrayList<>(combine));
            combine.remove(combine.size() - 1);
            return;
        }
        if (root == null) {
            return;
        }
        combine.add(root.val);
        dfs(root.left, ans, combine, target - root.val);
        dfs(root.right, ans, combine, target - root.val);
        combine.remove(combine.size() - 1);
    }
}
