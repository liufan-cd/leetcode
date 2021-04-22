package person.liufan.leetcode.thousand.hundred.forth.seventh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.seventh
 * @description: TODO
 * @date 2021/4/1
 */
public class PermuteUnique {
    public void dfs(List<List<Integer>> lists, List<Integer> combine, int[] nums, boolean[] isUsed) {
        if (combine.size() == nums.length) {
            lists.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                continue;
            }
            if (!isUsed[i]) {
                isUsed[i] = true;
                combine.add(nums[i]);
                dfs(lists,combine, nums, isUsed);
                combine.remove(combine.size() - 1);
                isUsed[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> combine = new ArrayList<>();
        dfs(lists,combine, nums, isUsed);
        return lists;
    }
}
