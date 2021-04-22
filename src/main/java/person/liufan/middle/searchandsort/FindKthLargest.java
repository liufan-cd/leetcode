package person.liufan.middle.searchandsort;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.searchandsort
 * @description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @date 2021/4/19
 */
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] param = new int[]{1,3,2,3,3,3};
        findKthLargest.quickSort(param,0,5);
        System.out.println(Arrays.toString(param));
    }
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] ints, int left, int right) {
        int i = left, j = right;
        if (left >= right) {
            return;
        }
        int compare = ints[left++];
        while (left < right) {
            while (ints[left] <= compare && left != right) {
                left++;
            }
            while ((ints[right] > compare && left != right)) {
                right--;
            }
            exchange(ints, left, right);
        }
        if (compare > ints[left]) {
            exchange(ints, i, left);
            quickSort(ints, i, left - 1);
            quickSort(ints, left + 1, j);
        } else {
            exchange(ints, i, left - 1);
            quickSort(ints, i, left - 2);
            quickSort(ints, left, j);
        }
    }

    public void exchange(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }
}
