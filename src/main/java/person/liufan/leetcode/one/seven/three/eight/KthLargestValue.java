package person.liufan.leetcode.one.seven.three.eight;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.seven.three.eight
 * @description: 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/19
 */
public class KthLargestValue {
    public static void main(String[] args) {
        KthLargestValue kthLargestValue = new KthLargestValue();
        System.out.println(kthLargestValue.kthLargestValue(new int[][]{
                {5, 2},
                {1, 6}
        }, 2));
    }
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] ^= matrix[i][j - 1];
            }
        }
        int l = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] ^= matrix[i - 1][j];
            }
        }
        for (int[] ints : matrix) {
            for (int num:ints) {
                ans[l++] = num;
            }
        }
        Arrays.sort(ans);
        return ans[ans.length - k];
    }
}
