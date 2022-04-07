package person.liufan.leetcode.zero.zero.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays2 {
    public static void main(String[] args) {
        FindMedianSortedArrays2 findMedianSortedArrays = new FindMedianSortedArrays2();
        int[] nums1 = {2};
        int[] nums2 = {1,3,4,5};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
    /**
     * 使用一个temp缓存数组，解决了两个指针比较两个数组四个数字容易造成的越界
     * 但是这个temp数组也会造成越界，当在比较的时候有些特殊情况也会造成越界
     * 数组越界，分情况解决种类太多，再次放弃这种方案
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //定义一个指针i
        int i = 0;
        //定义一个指针j
        int j = 0;
        int[] temp = new int[(nums1.length + nums2.length + 3) / 2];
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0) {
                    return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
                } else {
                    return nums2[nums2.length / 2];
                }
            } else if (nums2.length == 0) {
                if (nums1.length % 2 == 0) {
                    return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
                } else {
                    return nums1[nums1.length / 2];
                }
            }
        }
        if ((nums1.length == 0 || nums1[nums1.length - 1] <= nums2[0])) {
            j = (nums1.length + nums2.length + 1) / 2;
            if (j - 1 < nums1.length) {
                temp[j - 1] = nums1[j - 1];
            } else {
                temp[j - 1] = nums2[j - nums1.length - 1];
            }
            if (j < nums1.length) {
                temp[j] = nums1[j];
            } else {
                temp[j] = nums2[j - nums1.length];
            }
        } else if ((nums2.length == 0 || nums2[nums2.length - 1] <= nums1[0])) {
            i = (nums1.length + nums2.length + 1) / 2;
            if (i - 1 < nums2.length) {
                temp[i - 1] = nums2[i - 1];
            } else {
                temp[i - 1] = nums1[i - nums2.length - 1];
            }
            if (i < nums2.length) {
                temp[i] = nums2[i];
            } else {
                temp[i] = nums1[i - nums2.length];
            }
        } else {
            while (true) {
                if (nums1[i] > nums2[j]) {
                    temp[i + j] = nums2[j];
                    j++;
                } else {
                    temp[i + j] = nums1[i];
                    i++;
                }
                if (i + j >= (nums1.length + nums2.length + 1) / 2) {
                    if (i == nums1.length) {
                        temp[i + j] = nums2[j];
                    } else if (j == nums2.length) {
                        temp[i + j] = nums1[i];
                    } else {
                        if (nums1[i] > nums2[j]) {
                            temp[i + j] = nums2[j];
                        } else {
                            temp[i + j] = nums1[i];
                        }
                    }
                    break;
                }
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (temp[i + j - 1] + temp[i + j]) / 2d;
        } else {
            return temp[i + j - 1];
        }
    }
}
