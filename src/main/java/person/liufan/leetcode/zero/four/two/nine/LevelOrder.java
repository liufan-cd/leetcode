package person.liufan.leetcode.zero.four.two.nine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.four.two.nine
 * @description:
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * @date 2022/4/8
 */
public class LevelOrder {
    // 层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            // 记录当前层级个数
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();

            // 遍历该层
            for (int i = 0; i < size; i++) {
                // 获取该层节点
                Node node = queue.pollFirst();
                // 处理节点逻辑
                levelList.add(node.val);
                // 添加子节点到队列
                queue.addAll(queue.size() - 1, node.children);
            }

            // 处理整层逻辑
            ans.add(levelList);
        }

        return ans;
    }

    // 多叉树
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
