package person.liufan.middle.searchandsort;

import person.liufan.common.TreeUtils;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.searchandsort
 * @description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @date 2021/4/19
 */
public class FindKthLargest2 {
    public static void main(String[] args) {
        FindKthLargest2 findKthLargest = new FindKthLargest2();
        int[] param = new int[]{1,3,2,5,3,23,4,7,534,346};
        System.out.println(findKthLargest.findKthLargest(param, 5));
        System.out.println(Arrays.toString(param));
    }
    public int findKthLargest(int[] nums, int k) {
        heapSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void heapSort(int[] nums, int left, int right) {
        buildHeap(nums);
        while (left < right) {
            exchange(nums, left, right);
            right--;
            adjust(nums, 0, right);
        }
    }

    /**
     * 当前节点为i，子节点为2i+1，和2i+2
     * 父节点为（i-1）/2
     */
    private void adjust(int[] nums, int start, int end) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        if (left > end) {
            return;
        }
        if (left < nums.length && nums[start] < nums[left]) {
            exchange(nums, start, left);
            adjust(nums, left, end);
        }
        if (right > end) {
            return;
        }
        if (right < nums.length && nums[start] < nums[right]) {
            exchange(nums, start, right);
            adjust(nums, right, end);
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
    }

    private void exchange(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
