package person.liufan.advanced.linked;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.linked
 * @description: TODO
 * @date 2021/4/22
 */
public class CopyRandomList2 {
    public static void main(String[] args) {
        CopyRandomList2 copyRandomList = new CopyRandomList2();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        copyRandomList.copyRandomList(node0);
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node tempNode = head;
        while (tempNode != null) {
            Node node = new Node(tempNode.val);
            Node pre = tempNode;
            tempNode = tempNode.next;
            pre.next = node;
            node.next = tempNode;
        }
        tempNode = head;
        while (tempNode != null) {
            if (tempNode.random != null) {
                tempNode.next.random = tempNode.random.next;
            }
            tempNode = tempNode.next.next;
        }
        tempNode = head;
        Node result = new Node(0);
        Node temp = result;
        while (tempNode != null) {
            temp.next = tempNode.next;
            temp = temp.next;
            tempNode.next = tempNode.next.next;
            tempNode = tempNode.next;
        }
        return result.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
