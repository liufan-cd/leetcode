package person.liufan.leetcode.zero.three.nine.eight;

import java.util.Random;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.nine.eight
 * @description:
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * @date 2022/4/25
 */
public class RandomPick {
    public static void main(String[] args) {
        RandomPick randomPick = new RandomPick(new int[]{1, 1, 4});
    }

    private final int[] nums;
    private final Random random = new Random();

    public RandomPick(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int ans = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == target) {
                if (random.nextInt(++count) == 0) {
                    ans = i;
                }
            }
        }

        return ans;
    }

    /*private int binarySearch(int key) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }*/
}
