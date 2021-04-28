package person.liufan.leetcode.thousand.nine.three.eight;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.nine.three.eight
 * @description: TODO
 * @date 2021/4/27
 */
public class RangeSumBST {
    public static void main(String[] args) {
        //TreeNode param = TreeUtils.deserialize("10,5,15,3,7,null,18");
        //TreeNode param = TreeUtils.deserialize("10,5,15,3,7,13,18,1,null,6");
        TreeNode param = TreeUtils.deserialize("18,9,27,6,15,24,30,3,null,12,null,21");
        param.printTree();
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(param, 18, 24));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return sum;
    }

    int sum = 0,low, high;
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val >= low) {
            dfs(root.left);
        }
        if (root.val <= high) {
            dfs(root.right);
        }
    }
}
