package person.liufan.leetcode.zero.zero.zero.first;

import java.util.HashMap;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17
 */
public class TwoSum2 {
    public static void main(String[] args) {
    }
    public int[] twoSum(int[] nums, int target) {
        /**
         * 本质上也进行了两次遍历，可是hashmap的查询key时间复杂度比全表扫描来的快
         */
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = {i, map.get(target - nums[i])};
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}