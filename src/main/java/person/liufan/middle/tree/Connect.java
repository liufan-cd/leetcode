package person.liufan.middle.tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.tree
 * @description: TODO
 * @date 2021/4/19
 */
public class Connect {
    public static void main(String[] args) {
        Connect connect = new Connect();
    }
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    List<Node> preNode = new ArrayList<>();
    int layer = 0;
    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (preNode.size() == layer) {
            preNode.add(root);
        } else {
            preNode.get(layer).next = root;
            preNode.set(layer, root);
        }
        layer++;
        dfs(root.left);
        dfs((root.right));
        layer--;
    }
}






















class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
