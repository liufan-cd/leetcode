package person.liufan.leetcode.thousand.hundred.third.tenth;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class combinationSum2 {
    public static void main(String[] args) {
        combinationSum2 combinationSum = new combinationSum2();
        System.out.println(combinationSum.combinationSum2(new int[  ]{10,1,2,7,6,1,5}, 8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(results, combine, candidates, target, 0);
        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> combine, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(combine));
            return;
        }
        dfs(results, combine, candidates, target, index + 1);
        if (index != 0 && candidates[index] == candidates[index - 1]) {
            return;
        }
        if (target >= candidates[index]) {
            if (candidates[index] == 1) {
                combine.add(candidates[index]);
                combine.add(candidates[index]);
                dfs(results, combine, candidates, target - 2, index + 1);
            } else {
                combine.add(candidates[index]);
                dfs(results, combine, candidates, target - candidates[index], index + 1);
                combine.remove(combine.size() - 1);
            }
            if (candidates[index] == 1) {
                combine.remove(combine.size() - 1);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
