package person.liufan.leetcode.zero.zero.three.fifth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.fifth
 * @description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 * @date 2021/3/27
 */
public class SearchInsert2 {
    public static void main(String[] args) {
        SearchInsert2 searchInsert = new SearchInsert2();
        System.out.println(searchInsert.searchInsert(new int[]{4},7));
    }
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            //什么条件下缩进右边界？
            //当中间数等于的时候到底缩不缩，等于缩右边，最后会让结果偏左，有重复的话，
            //先判断左边界还是右边界，先缩右边会让结果偏小
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
