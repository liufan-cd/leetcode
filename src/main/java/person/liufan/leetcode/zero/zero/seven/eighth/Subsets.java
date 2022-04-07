package person.liufan.leetcode.zero.zero.seven.eighth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.eighth
 * @description:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @date 2021/4/7
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{

        }));
    }
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return results;
    }

    public void dfs(int offset) {
        if (offset == nums.length) {
            results.add(new ArrayList<>(combine));
            return;
        }
        dfs(offset + 1);
        combine.add(nums[offset]);
        dfs(offset + 1);
        combine.remove(combine.size() - 1);
    }
}

