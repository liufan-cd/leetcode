package person.liufan.leetcode.thousand.six.five.three;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.six.five.three
 * @description: TODO
 * @date 2022/3/21
 */
public class FindTarget {
    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        TreeNode root = TreeUtils.deserialize("5,3,6,2,4,null,7");
        System.out.println(findTarget.findTarget(root, 18));
    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode leftNode = root;
        TreeNode rightNode = root;

        // 左节点压栈
        while (leftNode.left != null) {
            left.push(leftNode);
            leftNode = leftNode.left;
        }

        // 右节点压栈
        while (rightNode.right != null) {
            right.push(rightNode);
            rightNode = rightNode.right;
        }

        while (leftNode != rightNode) {
            // 判断和
            int sum = leftNode.val + rightNode.val;

            if (sum == k) {
                return true;
            }

            // 左节点右移一位
            if (sum < k) {
                // 如果有右节点，递归至右节点的左边界，没有则使用父节点
                if (leftNode.right != null) {
                    leftNode = leftNode.right;
                    while (leftNode.left != null) {
                        left.push(leftNode);
                        leftNode = leftNode.left;
                    }
                } else {
                    leftNode = left.pop();
                }
            }

            // 右节点左移一位
            if (sum > k) {
                // 如果有左节点，递归到左节点的右边界，没有使用父节点
                if (rightNode.left != null) {
                    rightNode = rightNode.left;
                    while (rightNode.right != null) {
                        right.push(rightNode);
                        rightNode = rightNode.right;
                    }
                } else {
                    rightNode = right.pop();
                }
            }
        }

        return false;
    }
}
