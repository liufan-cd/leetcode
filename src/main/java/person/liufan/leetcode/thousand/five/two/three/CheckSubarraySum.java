package person.liufan.leetcode.thousand.five.two.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.five.two.three
 * @description:
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/2
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{1,1000000000}, 1));
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{0}, 1));
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{5,0,0,0}, 7));
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int maxN = num / k;
            map.merge(num, i, (a, b) -> a);
            for (int j = maxN; j > -1; j--) {
                if (map.containsKey(num - (k * j))) {
                    if (i - map.get(num - (k * j)) >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
