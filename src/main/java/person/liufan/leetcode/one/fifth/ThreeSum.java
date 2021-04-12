package person.liufan.leetcode.one.fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int num0 = 0;
        for (int first = 0; first <= nums.length - 1; first++) {
            if (nums[first] == 0) {
                num0++;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second <= nums.length - 1; second++) {
                for (; third >= second + 1; third--) {
                    while (second < nums.length - 1 && nums[second + 1] == nums[second]) {
                        second++;
                    }
                    while (third >= 1 && nums[third - 1] == nums[third]) {
                        third--;
                    }
                    boolean flag1 = nums[first] + nums[second] + nums[third] == 0;
                    boolean flag2 = first != second && second != third && first != third;
                    boolean flag3 = nums[first] == 0 && nums[second] == 0 && nums[third] == 0;
                    if (flag1 && flag2 && !flag3) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        lists.add(list);
                    }
                }
            }
        }
        if (num0 >= 3) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            lists.add(list);
        }
        return lists;
    }
}
