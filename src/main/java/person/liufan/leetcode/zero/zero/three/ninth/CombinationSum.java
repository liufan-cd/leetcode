package person.liufan.leetcode.zero.zero.three.ninth;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.ninth
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/30
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3,5}, 8));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target,int index) {
        Arrays.sort(candidates);
        List<List<Integer>> all = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> results = new ArrayList<>();
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            }
            if (target == candidate) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(target);
                results.add(result);
            } else {
                List<List<Integer>> list = combinationSum(candidates, target - candidate,i);
                results.addAll(list);
                addToResults(results, candidate);
            }
            all.addAll(results);
        }
        return all;
    }

    private List<List<Integer>> addToResults(List<List<Integer>> results, int target) {
        if (results != null) {
            results.stream().forEach(result -> {
                result.add(target);
            });
        }
        return results;
    }
}
