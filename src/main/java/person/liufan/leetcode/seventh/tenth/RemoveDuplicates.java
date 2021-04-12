package person.liufan.leetcode.seventh.tenth;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.seventh.tenth
 * @description:
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        //int[] param = new int[]{1,1,1,2,2,3};
        int[] param = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates.removeDuplicates(param));
        System.out.println(Arrays.toString(param));
    }
    public int removeDuplicates(int[] nums) {
        boolean flag = false;
        int pre = nums[0];
        int low = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == pre) {
                if (flag) {
                    continue;
                } else {
                    flag = true;
                }
            } else {
                flag = false;
                pre = nums[fast];
            }
            nums[low] = nums[fast];
            low++;
        }
        return low;
    }
}
