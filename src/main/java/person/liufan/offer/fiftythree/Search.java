package person.liufan.offer.fiftythree;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftythree
 * @description: 统计一个数字在排序数组中出现的次数。
 * @date 2021/5/21
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{1,4}, 4));
    }
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int i = binarySearch(nums, target);
        if (i == 0) {
            if (nums.length < 2 || nums[1] != target) {
                return 0;
            }
        }
        return binarySearch(nums, target + 1) - i;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left - 1 : left;
    }
}
