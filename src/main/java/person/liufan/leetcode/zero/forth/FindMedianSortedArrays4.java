package person.liufan.leetcode.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays4 {
    public static void main(String[] args) {
        FindMedianSortedArrays4 findMedianSortedArrays = new FindMedianSortedArrays4();
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};
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
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 代码实现
         * 123456798
         *
         * 123456789
         */
        //起始下标
        int offset1 = -1;
        int offset2 = -1;
        //删除数量
        int offset = 0;
        //需要排除的元素总量
        int exclusion = (nums1.length + nums2.length - 1) / 2;

        while (true) {
            //计算此次需要排除的偏移量
            exclusion = exclusion - offset;
            offset = exclusion / 2 == 0 ? 1 : exclusion / 2;
            if (nums1.length + nums2.length == 1) {
                return nums1.length == 1 ? nums1[0] : nums2[0];
            }
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
            if (offset1 + offset == nums1.length || nums1.length == 0) {
                exclusion = exclusion + offset2 + 1;
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return exclusion <= 0 ? (nums1[nums1.length - 1] + nums2[exclusion + 1]) / 2d : (nums2[exclusion] + nums2[exclusion + 1]) / 2d;
                } else if ((nums1.length + nums2.length) % 2 != 0) {
                    return nums2[exclusion];
                }
            } else if (offset2 + offset == nums2.length || nums2.length == 0) {
                exclusion = exclusion + offset1 + 1;
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return exclusion <= 0 ? (nums1[exclusion + 1] + nums2[nums2.length - 1]) / 2d : (nums1[exclusion] + nums1[exclusion + 1]) / 2d;
                } else if ((nums1.length + nums2.length) % 2 != 0) {
                    return nums2[exclusion];
                }
            }
            if (nums1[offset1 + offset] <= nums2[offset2 + offset]) {
                offset1 += offset;
            } else {
                offset2 += offset;
            }
            if (exclusion <= 0) {
                if ((nums1.length + nums2.length) % 2 == 0 && exclusion < 0) {
                    return (nums1[offset1] + nums2[offset2]) / 2d;
                } else if ((nums1.length + nums2.length) % 2 != 0){
                    if (offset1 == -1) {
                        return nums2[offset2 - 1] >= nums2[offset2] ? nums2[offset2 - 1] : nums2[offset2];
                    } else if (offset2 == -1) {
                        return nums1[offset1] >= nums1[offset1 - 1] ? nums1[offset1] : nums1[offset1 - 1];
                    }
                    return nums1[offset1] >= nums2[offset2] ? nums1[offset1] : nums2[offset2];
                }
            }
        }
    }
}
