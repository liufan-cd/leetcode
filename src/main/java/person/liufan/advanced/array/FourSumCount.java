package person.liufan.advanced.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description: 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwqm6c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/21
 */
public class FourSumCount {
    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        System.out.println(fourSumCount.fourSumCount(nums1, nums2, nums3, nums4));
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>(500);
        int size = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                size += map.getOrDefault(-(c + d), 0);
            }
        }
        return size;
    }
    /*public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        int index1 = 0;
        int index2 = 0;
        int result = 0;
        while (index1 < nums1.length) {
            while (index2 < nums2.length) {
                int index4 = nums4.length - 1;
                int index3 = 0;
                while (index3 <= index4) {
                    int sum = nums1[index1] + nums2[index2] + nums3[index3] + nums4[index4];
                    if (sum == 0) {
                        result++;
                        index4--;
                    } else if (sum > 0) {
                        index4--;
                    } else {
                        index3++;
                    }
                }
                index2++;
            }
            index1++;
        }
        return result;
    }*/
}
