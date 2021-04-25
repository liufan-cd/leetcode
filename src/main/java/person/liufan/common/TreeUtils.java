package person.liufan.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.common
 * @description: LeetCode字符串生成树工具类，解析树生成字符串工具类
 * @date 2021/4/25
 */
public class TreeUtils {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        dfs(root);
        StringBuilder builder = new StringBuilder();
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                builder.append(integer).append(",");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    static int layer = 0;
    static List<List<Integer>> result = new ArrayList<>();
    public static void dfs(TreeNode root) {
        if (root == null) {
            if (layer == result.size()) {
                List<Integer> layerNumbers = new ArrayList<>();
                layerNumbers.add(null);
                result.add(layerNumbers);
            } else {
                result.get(layer).add(null);
            }
            return;
        }
        if (layer == result.size()) {
            List<Integer> layerNumbers = new ArrayList<>();
            layerNumbers.add(root.val);
            result.add(layerNumbers);
        } else {
            result.get(layer).add(root.val);
        }
        layer++;
        dfs(root.left);
        dfs(root.right);
        layer--;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] split = data.split(",");
        Queue<TreeNode> preLayer = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        preLayer.add(root);
        int index = 1;
        boolean isLeft = true;
        while (index != split.length) {
            Queue<TreeNode> thisLayer = new ArrayDeque<>();
            while (preLayer.size() != 0) {
                String val = split[index];
                index++;
                if (!val.equals("null")) {
                    TreeNode treeNode = new TreeNode(Integer.parseInt(val));
                    thisLayer.add(treeNode);
                    if (isLeft) {
                        TreeNode parent = preLayer.peek();
                        parent.left = treeNode;
                        isLeft = false;
                    } else {
                        TreeNode parent = preLayer.poll();
                        parent.right = treeNode;
                        isLeft = true;
                    }
                } else {
                    if (isLeft) {
                        TreeNode parent = preLayer.peek();
                        isLeft = false;
                    } else {
                        TreeNode parent = preLayer.poll();
                        isLeft = true;
                    }
                }
                if (index == split.length) {
                    break;
                }
            }
            preLayer = thisLayer;
        }
        return root;
    }

}
