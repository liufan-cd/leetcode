package person.liufan.leetcode.third.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.third.forth
 * @description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/26
 */
public class SearchRange {
    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);

        }
    }
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return new int[]{-1, -1};
        } else if (nums[0] > target || nums[size - 1] < target){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = size - 1;
        int middle = (left + right) / 2;
        int[] result = new int[2];
        if (nums[0] != target) {
            //定位左边界，左边界元素，左边小于target，右边大于等于target
            while (true) {
                if (nums[middle] == target && nums[middle - 1] < target) {
                    break;
                }
                if (right == left) {
                    return new int[]{-1, -1};
                }
                if (target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
                middle = (left + right) / 2;
            }
            result = new int[]{middle,middle};
        }
        left = 0;
        right = size - 1;
        middle = (left + right) / 2;
        if (nums[size - 1] != target) {
            while (true) {
                if (nums[middle] > target && nums[middle - 1] == target) {
                    break;
                }
                if (right <= left) {
                    result[1] = middle;
                    return result;
                }
                if (target >= nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
                middle = (left + right) / 2;
            }
            result[1] = middle - 1;
        } else {
            result[1] = size - 1;
        }
        return result;
    }
}
