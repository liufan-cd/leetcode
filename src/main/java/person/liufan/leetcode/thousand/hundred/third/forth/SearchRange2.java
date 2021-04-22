package person.liufan.leetcode.thousand.hundred.third.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.forth
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
public class SearchRange2 {
    public static void main(String[] args) {
        SearchRange2 searchRange = new SearchRange2();
        int[] ints = searchRange.searchRange(new int[]{1 , 1 ,1}, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (r < 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l >= n || nums[l] != target) {
            return new int[]{-1, -1};
        }
        result[0] = l;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target >= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        result[1] = r;
        return result;
    }
}
