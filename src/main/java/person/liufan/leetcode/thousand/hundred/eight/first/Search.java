package person.liufan.leetcode.thousand.hundred.eight.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.first
 * @description: TODO
 * @date 2021/4/7
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        //System.out.println(search.search(new int[]{0,1,2,3,4,5,6,7,8,9}, 9,0,9));
        System.out.println(search.search(new int[]{1,3}, 1));
    }
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        while (left < right) {
            //右半区平的
            if (nums[middle] < nums[right]) {
                if (nums[middle] <= target && target <= nums[right]) {
                    return search(nums, target, middle, right) != -1;
                } else {
                    right = middle - 1;
                    middle = (left + right) / 2;
                }
            } else if (nums[left] < nums[middle]) {
                if (nums[left] <= target && target <= nums[middle]) {
                    return search(nums, target, left, middle) != -1;
                } else {
                    left = middle + 1;
                    middle = (left + right) / 2;
                }
            } else if (nums[left] == target) {
                return true;
            } else {
                left++;
                right--;
                middle = (left + right) / 2;
            }
        }
        return (left < nums.length && nums[left] == target) || (right >= 0 && nums[right] == target);
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
