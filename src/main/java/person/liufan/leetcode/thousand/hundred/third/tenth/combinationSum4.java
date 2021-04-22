package person.liufan.leetcode.thousand.hundred.third.tenth;


import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.tenth
 * @description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/30
 */
public class combinationSum4 {
    public static void main(String[] args) {
        combinationSum4 combinationSum = new combinationSum4();
        System.out.println(combinationSum.combinationSum2(new int[  ]{2,5,2,1,2}, 5));
    }

    Map<Integer, Integer> map = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combine = new ArrayList<>(candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            Integer integer = map.get(candidate);
            if (integer == null) {
                map.put(candidate, 1);
            } else {
                map.put(candidate, ++integer);
            }
        }
        dfs(results, combine, candidates, target, 0);
        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> combine, int[] candidates, int target, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(combine));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        dfs(results, combine, candidates, target, index + 1);
        if (index != 0 && candidates[index] == candidates[index - 1]) {
            return;
        }
        if (target >= candidates[index]) {
            Integer integer = map.get(candidates[index]);
            for (int i = 1; i <= integer; i++) {
                combine.add(candidates[index]);
                dfs(results, combine, candidates, target - candidates[index] * i, index + 1);
            }
            for (int i = 1; i <= integer; i++) {
                combine.remove(combine.size() - 1);
            }
        }
    }
}
