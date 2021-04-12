package person.liufan.leetcode.one.sixth;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.sixth
 * @description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/23
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{1,1,1,0},100));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                while (second < third && nums[first] + nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    int more;
                    if (third < n - 1) {
                        more = nums[first] + nums[second] + nums[third + 1];
                    }else {
                        continue;
                    }
                    if (more - target <= Math.abs(target - result)) {
                        result = more;
                    }
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == target) {
                    return target;
                }
                if (nums[first] + nums[second] + nums[third] < target) {
                    if (third < n - 1) {
                        int less = nums[first] + nums[second] + nums[third];
                        int more = nums[first] + nums[second] + nums[third + 1];
                        //小的值更接近
                        if (target - less <= more - target) {
                            if (target - less <= Math.abs(target - result)) {
                                result = less;
                            }
                            //大的值更接近
                        } else {
                            if (more - target <= Math.abs(target - result)) {
                                result = more;
                            }
                        }
                    } else {
                        int less = nums[first] + nums[second] + nums[third];
                        if (target - less <= Math.abs(target - result)) {
                            result = less;
                        }
                    }
                }
            }
        }
        return result;
    }
}
