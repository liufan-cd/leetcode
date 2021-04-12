package person.liufan.leetcode.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays6 {
    public static void main(String[] args) {
        FindMedianSortedArrays6 findMedianSortedArrays = new FindMedianSortedArrays6();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1,nums2));
        //System.out.println(findMedianSortedArrays.findNumber(nums1,4));
    }
    /**
     * 一个数组中中位数必定出现在两个数组中间的位置
     * 如果舍弃较小的前半部分，较大数组的后半部分，完全没有问题，如果每次舍弃的数量一样，中位数就不会变（错误）
     * 不应该用通过缩减数组长度的方法递归求中位数
     * 问题是如何判断是否应该舍弃呢
     *
     * 中位数在一开始就确定好了是第k个元素，他的前面一共有k-1个元素
     * 只要我一直舍弃前面k-1个元素就能求出中位数
     * 之前的方法虽然是通过指针来确定元素，本质上还是过滤了前面的元素，所以根本用不上数组缓存
     * 所以之前是循环遍历舍弃，这个方法是使用二分法舍弃
     *
     *
     * 太冗余了，应该在一开始的时候排除特殊情况，有一个数组为空，数组数量较小的情况
     * 应该在两个长度都小于3的时候遍历排序
     * 大于的情况下用二分法排序
     *
     * 情况太多，根本处理不了
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //需要排除的元素总量
        int exclusion = (nums1.length + nums2.length - 1) / 2;
        //为空返回
        if (nums1.length == 0) {
            if ((nums1.length + nums2.length) % 2 == 0) {
                return (nums2[exclusion] + nums2[exclusion + 1]) / 2d;
            } else if ((nums1.length + nums2.length) % 2 != 0) {
                return nums2[exclusion];
            }
        }
        if (nums2.length == 0) {
            if ((nums1.length + nums2.length) % 2 == 0) {
                return (nums1[exclusion] + nums1[exclusion + 1]) / 2d;
            } else if ((nums1.length + nums2.length) % 2 != 0) {
                return nums1[exclusion];
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            int mid1 = findResult(nums1, nums2, exclusion);
            int mid2 = findResult(nums1, nums2, exclusion + 1);
            return (mid1 + mid2) / 2d;
        } else {
            return findResult(nums1, nums2, exclusion);
        }
    }
    public int findResult(int[] nums1, int[] nums2, int exclusion) {
        if (nums1[nums1.length / 2] > nums2[nums2.length / 2]) {
            this.findMedianSortedArrays(nums2, nums1);
        }
        int left = nums1[nums1.length / 2];
        int right = nums2[nums2.length / 2];
        //判断元素在第一个数组的下标
        int index1;
        //判断元素在第二个数组的下标
        int index2;
        int mid = (left + right) / 2;
        int number;
        while (true) {
            mid = (left + right) / 2;
            if (left >= right) {
                return mid;
            }
            number = findNumber(nums1, nums2, mid);
            if (number < exclusion) {
                left = mid + 1;
            } else if (number > exclusion) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
    }
    public int findNumber(int[] nums1, int[] nums2, int target) {
        return findNumber(nums1, target) + findNumber(nums2, target);
    }
    /**
     * 数组中小于该数字的个数
     */
    public int findNumber(int[] num, int target) {
        if (target > num[num.length - 1]) {
            return num.length;
        }
        //定义边界
        int left = 0;
        int right = num.length;
        int index = 0;
        while (left < right) {
            index = (left + right) / 2;
            if (num[index] < target) {
                left = index + 1;
            } else if (num[index] > target) {
                right = index - 1;
            } else {
                if (index + 1 <= num.length - 1) {
                    if (num[index] == num[index + 1]) {
                        while (num[index] == num[index + 1]) {
                            index++;
                        }
                        index++;
                    }
                }
                return index;
            }
        }
        return index;
    }

}
