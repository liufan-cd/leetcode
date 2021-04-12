package person.liufan.leetcode.forth.sixth;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.forth.sixth
 * @description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @date 2021/4/1
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1,2,3}));
    }
    List<List<Integer>> results = new ArrayList<>();
    public void dfs(List<Integer> combine, int[] nums, boolean[] isUsed) {
        if (combine.size() == nums.length) {
            results.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                combine.add(nums[i]);
                dfs(combine, nums, isUsed);
                combine.remove(combine.size() - 1);
                isUsed[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> combine = new ArrayList<>();
        dfs(combine, nums, isUsed);
        return results;
    }
}
