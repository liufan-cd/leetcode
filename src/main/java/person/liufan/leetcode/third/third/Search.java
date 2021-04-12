package person.liufan.leetcode.third.third;

import java.io.Serializable;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.third.third
 * @description:
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/26
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        //System.out.println(search.search(new int[]{0,1,2,3,4,5,6,7,8,9}, 9,0,9));
        System.out.println(search.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        while (true) {
            if (nums[left]  <= nums[right]) {
                return search(nums, target, left, right);
            }
            //右半区平的
            if (nums[middle] <= nums[right]) {
                if (nums[middle] <= target && target <= nums[right]) {
                    return search(nums, target, middle, right);
                } else {
                    right = middle - 1;
                    middle = (left  + right) / 2;
                }
            } else if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target <= nums[middle]) {
                    return search(nums, target, left, middle);
                } else {
                    left = middle + 1;
                    middle = (left + right) / 2;
                }
            }
        }
    }

    public int search(int[] nums,int target,int offset,int end) {
        int left = offset;
        int right = end;
        int middle;
        if (nums[offset] == target) {
            return offset;
        }
        if (nums[end] == target) {
            return end;
        }
        while (true) {
            middle = (right + left) / 2;
            if (middle == left) {
                break;
            }
            if (nums[middle] == target) {
                return middle;
            }
            if (target > nums[left] && target < nums[middle]) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return -1;
    }
}
