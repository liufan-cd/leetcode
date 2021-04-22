package person.liufan.leetcode.thousand.hundred.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 使用两个指针直接指向每一个数组，造成指向的位置太多了，中位数要两两比较，很容易造成两个指针的越界
     * 数组越界，分情况解决种类太多，放弃这种方案
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0) {
                    return nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2] / 2d;
                } else {
                    return nums2[nums2.length / 2];
                }
            } else if (nums2.length == 0) {
                if (nums1.length % 2 == 0) {
                    return nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2] / 2d;
                } else {
                    return nums1[nums1.length / 2];
                }
            }
        }
        //定义一个指针i
        int i = 0;
        //定义一个指针j
        int j = 0;
        while (true) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
            if (i + j >= (nums1.length + nums2.length + 1)/2) {
                break;
            }
        }
        if (nums1.length == 0 || nums2.length == 0) {
            if (i == 0) {
                if (nums2.length % 2 == 0) {
                    return nums2[j - 1] + nums2[j] / 2d;
                } else {
                    return nums2[j - 1];
                }
            } else if (j == 0) {
                if (nums1.length % 2 == 0) {
                    return nums1[i - 1] + nums1[i] / 2d;
                } else {
                    return nums1[i - 1];
                }
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            //现在指针指向四个数，这四个数排序取中间两个
            double result1 = 0;
            double result2 = 0;
            if (i == 0) {
                return (j == nums2.length) ? (nums2[j - 1] + nums1[0]) / 2d : (nums2[j - 1] + nums2[j]) / 2d;
            } else if (j == 0) {
                return (i == nums1.length) ? (nums1[i - 1] + nums2[0]) / 2d : (nums1[i - 1] + nums1[i]) / 2d;
            } else {
                result1 = nums1[i - 1] > nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];
                result2 = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            }
            return (result1 + result2) / 2d;
        } else {
            //现在前两个数中取大的数
            if (i == 0) {
                return nums2[j - 1];
            } else if (j == 0) {
                return nums1[i - 1];
            } else {
                return nums1[i - 1] > nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];
            }
        }

    }
}
