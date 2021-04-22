package person.liufan.leetcode.thousand.hundred.zero.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @date 2021/3/18
 */
public class FindMedianSortedArrays3 {
    public static void main(String[] args) {
        FindMedianSortedArrays3 findMedianSortedArrays = new FindMedianSortedArrays3();
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
    /**
     * 使用一个temp缓存数组，解决了两个指针比较两个数组四个数字容易造成的越界
     * 在指针获取元素比较之前进行判断，是否越界，没有越界再进行合并数组，越界直接合并另一个数组移动指针
     * 当元素小于等于1的时候会越界，单独处理
     * 数组越界，分情况解决种类太多，再次放弃这种方案
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //定义一个指针i
        int i = 0;
        //定义一个指针j
        int j = 0;
        //缓存数组
        //实际上根本用不了一个数组，两个元素来保存即可，前一个元素，和当前指针元素，如果数量为奇数，就可以只用一个，为偶数除2
        int[] temp = new int[(nums1.length + nums2.length + 3) / 2];
        if (nums1.length + nums2.length == 1) {
            return nums1.length == 1 ? nums1[0] : nums2[0];
        }
        while (true) {
            if (i >= nums1.length) {
                temp[i + j] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                temp[i + j] = nums1[i];
                i++;
            } else {
                if (nums1[i] > nums2[j]) {
                    temp[i + j] = nums2[j];
                    j++;
                } else {
                    temp[i + j] = nums1[i];
                    i++;
                }
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
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (temp[i + j - 1] + temp[i + j]) / 2d;
        } else {
            return temp[i + j - 1];
        }
    }
}
