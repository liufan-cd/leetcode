package person.liufan.primary.tree;

import person.liufan.common.TreeNode;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.tree
 * @description: TODO
 * @date 2021/4/15
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{1,2});
        treeNode.printTree();
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return toTree(0, nums.length - 1);
    }

    int[] nums;
    public TreeNode toTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        return new TreeNode(nums[mid], toTree(left, mid - 1), toTree(mid + 1, right));
    }
}
