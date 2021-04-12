package person.liufan.leetcode.one.fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.fifth
 * @description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/22
 */
public class ThreeSum2 {
    public static void main(String[] args) {
        ThreeSum2 threeSum = new ThreeSum2();
        System.out.println(threeSum.threeSum(new int[]{0,0,0,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int num0 = 0;
        //外层循环
        for (int first = 0; first <= nums.length - 1; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            //第二层循环
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                boolean flag1 = nums[first] + nums[second] + nums[third] == 0;
                if (flag1) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
