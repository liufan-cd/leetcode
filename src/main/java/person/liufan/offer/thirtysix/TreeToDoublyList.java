package person.liufan.offer.thirtysix;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtysix
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @date 2021/5/17
 */
public class TreeToDoublyList {
    public static void main(String[] args) {

    }
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node();
        Node tail = dfs(root, head);
        root = head.right;
        root.left = tail;
        tail.right = root;
        return root;
    }

    public Node dfs(Node root, Node tail) {
        if (root == null) {
            return tail;
        }
        Node left = dfs(root.left, tail);
        left.right = root;
        root.left = left;
        return dfs(root.right, root);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
