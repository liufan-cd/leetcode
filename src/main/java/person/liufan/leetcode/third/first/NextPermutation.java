package person.liufan.leetcode.third.first;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.third.first
 * @description:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ints = new int[]{1,2,3};
        nextPermutation.nextPermutation(ints);
        for (int a : ints) {
            System.out.print(a);
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            int j = i + 1;
            if (j == nums.length) {
                continue;
            }
            if (nums[i] >= nums[j]) {
                continue;
            }
            while (j < nums.length && nums[i] < nums[j]) {
                j++;
            }
            if (j == nums.length || nums[i] >= nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(nums, 0, nums.length);
        }
    }
}
