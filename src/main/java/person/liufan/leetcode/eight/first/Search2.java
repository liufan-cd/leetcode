package person.liufan.leetcode.eight.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.eight.first
 * @description: TODO
 * @date 2021/4/7
 */
public class Search2 {
    public static void main(String[] args) {
        Search2 search = new Search2();
        //System.out.println(search.search(new int[]{0,1,2,3,4,5,6,7,8,9}, 9,0,9));
        System.out.println(search.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    int[] nums;
    int target;
    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target < nums[right]) {
                    return search(mid + 1, right);
                } else {
                    right = mid;
                }
            } else if (nums[left] < nums[mid]) {
                if (target <= nums[mid] && target > nums[left]) {
                    return search(left, mid);
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
                right--;
            }
        }
        return nums[left] == target || nums[right] == target;
    }
    public boolean search(int offset,int end) {
        int left = offset;
        int right = end;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target;
    }
}
