package person.liufan.leetcode.thousand.hundred.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays5 {
    public static void main(String[] args) {
        FindMedianSortedArrays5 findMedianSortedArrays = new FindMedianSortedArrays5();
        int[] nums1 = {2,2,4,4};
        int[] nums2 = {2,2,4,4};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
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
        /**
         * 当两个数组的长度都小于3时，合并数组进行排序
         */
        //需要排除的元素总量
        int exclusion = (nums1.length + nums2.length - 1) / 2;
        //判断是否有空的情况，有空的返回另一个数组
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
        if (nums1.length <= 3 || nums2.length <= 3) {
            //如果没有空，遍历合并数组至temp
            int[] temp = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            while ((i + j) < temp.length) {
                if (i == nums1.length) {
                    temp[i + j] = nums2[j];
                    j++;
                } else if (j == nums2.length) {
                    temp[i + j] = nums1[i];
                    i++;
                } else if (nums1[i] < nums2[j]) {
                    temp[i + j] = nums1[i];
                    i++;
                } else {
                    temp[i + j] = nums2[j];
                    j++;
                }
            }
            //获取temp数组中位数
            if (temp.length % 2 == 0) {
                return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2d;
            } else {
                return temp[temp.length / 2];
            }
        }
        /**
         * 使用二分法排除元素
         */
        //起始下标
        int offset1 = -1;
        int offset2 = -1;
        //删除数量
        int offset = 0;
        while (true) {
            //计算此次需要排除的偏移量
            exclusion = exclusion - offset;
            offset = exclusion / 2 == 0 ? 1 : exclusion / 2;
            //当下一次偏移量大于数组长度时，导致的数组越界
            if (offset1 + offset >= nums1.length) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (nums2[offset2 + exclusion] + nums2[offset2 + exclusion + 1]) / 2d;
                } else {
                    return nums2[offset2 + exclusion];
                }
            } else if (offset2 + offset >= nums2.length) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (nums1[exclusion] + nums1[exclusion + 1]) / 2d;
                } else {
                    return nums1[exclusion];
                }
            }
            //当下一次偏移量小于
            if (nums1[offset1 + offset] <= nums2[offset2 + offset]) {
                offset1 += offset;
            } else {
                offset2 += offset;
            }
            //剩余排除元素为0时
            if (exclusion <= 0) {
                //是偶数再进行一次循环
                if ((nums1.length + nums2.length) % 2 == 0) {
                    if (offset1 + 1 == nums1.length) {
                        int[] a = new int[1];
                        int[] b = new int[3];
                        a[0] = nums1[offset1];
                        b[0] = nums2[offset2];
                        b[1] = nums2[offset2 + 1];
                        b[2] = nums2[offset2 + 2];
                        return findMedianSortedArrays(a, b);
                    } else if (offset2 + 1 == nums2.length) {
                        int[] a = new int[3];
                        int[] b = new int[1];
                        b[0] = nums2[offset1];
                        a[0] = nums1[offset1];
                        a[1] = nums1[offset1 + 1];
                        a[2] = nums1[offset1 + 2];
                        return findMedianSortedArrays(a, b);
                    } else if (offset1 == -1) {
                        int[] a = new int[0];
                        int[] b = new int[1];
                        b[0] = nums2[offset1];
                        a[0] = nums1[offset1];
                        a[1] = nums1[offset1 + 1];
                        a[2] = nums1[offset1 + 2];
                        return findMedianSortedArrays(a, b);
                    } else if (offset2 == -1) {
                        int[] a = new int[3];
                        int[] b = new int[1];
                        b[0] = nums2[offset1];
                        a[0] = nums1[offset1];
                        a[1] = nums1[offset1 + 1];
                        a[2] = nums1[offset1 + 2];
                        return findMedianSortedArrays(a, b);
                    } else {
                        int[] a = new int[2];
                        int[] b = new int[2];
                        a[0] = nums1[offset1];
                        a[1] = nums1[offset1 + 1];
                        b[0] = nums2[offset2];
                        b[1] = nums2[offset2 + 2];
                        return findMedianSortedArrays(a, b);
                    }
                } else if ((nums1.length + nums2.length) % 2 != 0){
                    return nums1[offset1] >= nums2[offset2] ? nums1[offset1] : nums2[offset2];
                }
            }
        }
    }
}
