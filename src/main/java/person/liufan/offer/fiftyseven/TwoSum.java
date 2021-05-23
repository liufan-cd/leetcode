package person.liufan.offer.fiftyseven;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyseven
 * @description:
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * @date 2021/5/23
 */
public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{};
    }
}
