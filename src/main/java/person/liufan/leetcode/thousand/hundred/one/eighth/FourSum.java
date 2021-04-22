package person.liufan.leetcode.thousand.hundred.one.eighth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.one.eighth
 * @description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/23
 */
public class FourSum {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{},0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                int forth = length - 1;
                for (int third = second + 1; third < length; third++) {
                    if (third > second + 1 && nums[third - 1] == nums[third]) {
                        continue;
                    }
                    while (third < forth && nums[first] + nums[second] + nums[third] + nums[forth] > target) {
                        forth--;
                    }
                    if (third == forth) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] + nums[forth] == target) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[first]);
                        integers.add(nums[second]);
                        integers.add(nums[third]);
                        integers.add(nums[forth]);
                        lists.add(integers);
                    }
                }
            }
        }
        return lists;
    }
}
