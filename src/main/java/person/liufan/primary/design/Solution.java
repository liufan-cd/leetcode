package person.liufan.primary.design;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.design
 * @description: TODO
 * @date 2021/4/15
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.reset()));
        for (int i = 0; i < 50; i++) {
            System.out.println(Arrays.toString(solution.shuffle()));
        }
    }
    private int[] nums;
    private Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }
    /** Resets the array to its original configuration an
     * d return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            int index = random.nextInt(i + 1);
            exchange(result, index, i);
        }
        return result;
    }

    private void exchange(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
