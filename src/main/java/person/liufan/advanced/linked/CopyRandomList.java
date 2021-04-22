package person.liufan.advanced.linked;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.linked
 * @description: TODO
 * @date 2021/4/22
 */
public class CopyRandomList {
    public static void main(String[] args) {
        /*CopyRandomList copyRandomList = new CopyRandomList();
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
        node4.random = node1;
        copyRandomList.copyRandomList(node0);*/
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        Node tempNode = head;
        Map<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        while (tempNode != null) {
            Node node = new Node(tempNode.val);
            map.put(tempNode, size);
            list.add(node);
            if (size != 0) {
                list.get(size - 1).next = list.get(size);
            }
            tempNode = tempNode.next;
            size++;
        }
        tempNode = head;
        size = 0;
        while (tempNode != null) {
            Integer integer = map.get(tempNode.random);
            if (integer != null) {
                list.get(size).random = list.get(integer);
            }
            tempNode = tempNode.next;
            size++;
        }
        return list.get(0);
    }
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

