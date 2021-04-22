package person.liufan.leetcode.thousand.hundred.ninth.sixth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.sixth
 * @description:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @date 2021/4/12
 */
public class NumTrees {
    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(19));
    }
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return dfs(1,n);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int dfs(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int all = 0;
        for (int i = start; i <= end; i++) {
            int leftLength = i - start;
            int rightLength = end - i;
            int left,right;
            if (map.containsKey(leftLength)) {
                left = map.get(leftLength);
            } else {
                left = dfs(start, i - 1);
                map.put(leftLength, left);
            }
            if (map.containsKey(rightLength)) {
                right = map.get(rightLength);
            } else {
                right = dfs(i + 1, end);
                map.put(rightLength, right);
            }
            all += left * right;
        }
        return all;
    }
}
