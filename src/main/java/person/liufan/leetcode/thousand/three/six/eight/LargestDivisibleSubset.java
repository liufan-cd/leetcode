package person.liufan.leetcode.thousand.three.six.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.three.six.eight
 * @description: TODO
 * @date 2021/4/23
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{
                4,8,10,240
        }));
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxIndex = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0 && maxSize > 0; i--) {
            if (maxSize == dp[i] && nums[maxIndex] % nums[i] == 0) {
                result.add(nums[i]);
                maxIndex = i;
                maxSize--;
            }
        }
        return result;
    }
}
