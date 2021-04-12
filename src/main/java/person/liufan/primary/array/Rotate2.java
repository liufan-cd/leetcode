package person.liufan.primary.array;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: 旋转数组
 * @date 2021/4/12
 */
public class Rotate2 {
    public static void main(String[] args) {
        Rotate2 rotate = new Rotate2();
        int[] param = new int[]{1,2,3,4,5,6,7};
        //int[] param = new int[]{1,2};
        rotate.rotate(param, 2);
        System.out.println(Arrays.toString(param));
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
