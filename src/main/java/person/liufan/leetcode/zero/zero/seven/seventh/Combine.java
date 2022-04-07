package person.liufan.leetcode.zero.zero.seven.seventh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.seventh
 * @description:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @date 2021/4/7
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(0, 1));
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k - 1);
        return results;
    }

    public void dfs(int offset, int n, int k) {
        if (k < 0) {
            results.add(new ArrayList<>(combine));
            return;
        }
        for (int i = offset; i <= n - k; i++) {
            combine.add(i);
            dfs(i + 1, n, k - 1);
            combine.remove(combine.size() - 1);
        }
    }
}
