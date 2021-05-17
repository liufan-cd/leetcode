package person.liufan.offer.thirtytwo;

import person.liufan.common.ListNode;
import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtytwo
 * @description: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @date 2021/5/17
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(Arrays.toString(levelOrder.levelOrder(TreeUtils.deserialize("3,9,20,null,null,15,7"))));
        System.out.println(Arrays.toString(levelOrder.levelOrder(null)));
    }
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return new int[]{};
        }
        deque.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode poll = deque.pollLast();
            ans.add(poll.val);
            if (poll.left != null) {
                deque.push(poll.left);
            }
            if (poll.right != null) {
                deque.push(poll.right);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
