package person.liufan.advanced.array;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description:
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwz4lj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/21
 */
public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        //System.out.println(findDuplicate.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate.findDuplicate(new int[]{3,1,3,4,2,3}));
    }
    public int findDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return result;
    }

    int result;
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int leftRange = left;
        int rightRange = right;
        int compare = nums[left];
        left++;
        while (left < right) {
            while (left < right && nums[left] < compare) {
                left++;
            }
            while (left < right && nums[right] > compare) {
                right--;
            }
            if (left == right) {
                break;
            } else {
                if (nums[left] == nums[right]) {
                    result = nums[left];
                    return;
                }
                exchange(nums, left, right);
            }
        }
        if (compare == nums[left]) {
            result = nums[left];
            return;
        } else if (compare > nums[left]) {
            exchange(nums, leftRange, left);
            quickSort(nums, leftRange, left - 1);
            quickSort(nums, left + 1, rightRange);
        } else {
            exchange(nums, leftRange, left - 1);
            quickSort(nums, leftRange, left - 2);
            quickSort(nums, left, rightRange);
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
