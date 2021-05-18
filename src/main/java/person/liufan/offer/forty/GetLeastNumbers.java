package person.liufan.offer.forty;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.forty
 * @description:
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @date 2021/5/17
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(Arrays.toString(getLeastNumbers.getLeastNumbers(new int[]{0,0,0,2,0,5}, 0)));
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr);
        return Arrays.copyOf(arr, k);
    }
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int left, int right) {
        int i = left, j = right;
        if (left >= right) {
            return;
        }
        int compare = nums[left++];
        while (left < right) {
            while (nums[left] <= compare && left != right) {
                left++;
            }
            while ((nums[right] > compare && left != right)) {
                right--;
            }
            exchange(nums, left, right);
        }
        if (compare > nums[left]) {
            exchange(nums, i, left);
            quickSort(nums, i, left - 1);
            quickSort(nums, left + 1, j);
        } else {
            exchange(nums, i, left - 1);
            quickSort(nums, i, left - 2);
            quickSort(nums, left, j);
        }
    }

    public void exchange(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
