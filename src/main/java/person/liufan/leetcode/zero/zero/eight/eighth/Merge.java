package person.liufan.leetcode.zero.zero.eight.eighth;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.eighth
 * @description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/8
 */
public class Merge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] param = new int[]{
                1, 2, 3, 0, 0, 0
        };
        merge.merge(param,1,
                new int[]{
                        2,5,6
                },0);
        System.out.println(Arrays.toString(param));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        int j = 0;
        int current = 0;
        while (current < m + n && j < n) {
            if (current < m) {
                queue.add(nums1[current]);
            }
            if (queue.size() == 0) {
                break;
            }
            if (queue.peek() <= nums2[j]) {
                nums1[current++] = queue.poll();
            } else {
                nums1[current++] = nums2[j++];
            }
        }
        if (j == n) {
            while (current < m + n) {
                if (current < m) {
                    queue.add(nums1[current]);
                }
                if (queue.size() == 0) {
                    break;
                }
                nums1[current++] = queue.poll();
            }
        } else {
            while (j < n) {
                nums1[current++] = nums2[j++];
            }
        }
    }
}
