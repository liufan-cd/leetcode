package person.liufan.leetcode.zero.zero.five.third;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.third
 * @description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @date 2021/4/1
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{0}));
    }
    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length + 1];
        int most = max[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max[i] < 0) {
                max[i + 1] = nums[i];
            } else {
                max[i + 1] = max[i] + nums[i];
            }
            most = Math.max(max[i + 1], most);
        }
        return most;
    }
}
