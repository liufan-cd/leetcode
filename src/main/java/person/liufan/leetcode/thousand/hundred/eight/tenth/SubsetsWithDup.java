package person.liufan.leetcode.thousand.hundred.eight.tenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.tenth
 * @description:
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/9
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{
                1,2,2
        }));
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0, false);
        return result;
    }

    public void dfs(int index,boolean isChose) {
        if (index == nums.length) {
            result.add(new ArrayList<>(combine));
            return;
        }
        dfs(index + 1, false);
        if (!isChose && index > 0 && nums[index] == nums[index - 1]) {
            return;
        }
        combine.add(nums[index]);
        dfs(index + 1, true);
        combine.remove(combine.size() - 1);
    }
}
