package person.liufan.primary.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description:
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @date 2021/4/13
 */
public class ContainsDuplicate2 {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
