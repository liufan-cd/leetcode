package person.liufan.leetcode.thousand.three.seven.seven;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.three.seven
 * @description: TODO
 * @date 2021/4/24
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
