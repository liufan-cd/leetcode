package person.liufan.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.common
 * @description: TODO
 * @date 2021/4/9
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "";
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            if (root.right == null) {
                return;
            } else {
                dfs(root.right);
            }
        }
    }

    public TreeNode printTree() {
        getMaxDeep();
        for (int i = 1; i <= maxDeep; i++) {
            printOneLayer(i);
        }
        return this;
    }

    private void printOneLayer(int n) {
        int number = 1 << n - 1;
        int space = (1 << (maxDeep - n + 1)) - 1;
        int left = space >> 1;
        getLayerVal(this, n);
        for (int i = 0; i < left; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < number; i++) {
            if (layer.get(i) == null) {
                System.out.print((char)0x00F7);
            } else {
                System.out.print(layer.get(i));
            }
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
        layer = new ArrayList<>();
    }

    List<Integer> layer = new ArrayList<>();
    private void getLayerVal(TreeNode root, int n) {
        if (n == 1) {
            if (root == null) {
                layer.add(null);
            } else {
                layer.add(root.val);
            }
            return;
        }
        if (root == null) {
            getLayerVal(null, n - 1);
            getLayerVal(null, n - 1);
        } else {
            getLayerVal(root.left, n - 1);
            getLayerVal(root.right, n - 1);
        }
    }
    public int getMaxDeep() {
        getDeep(this, 1);
        return maxDeep;
    }
    int maxDeep = 0;
    private void getDeep(TreeNode root,int deep) {
        if (root != null) {
            maxDeep = Math.max(deep, maxDeep);
            getDeep(root.left, deep + 1);
            getDeep(root.right, deep + 1);
        }
    }
}
