package person.liufan.leetcode.zero.three.six.three;

import java.util.TreeSet;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.three.six.three
 * @description: 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/22
 */
public class MaxSumSubmatrix {
    public static void main(String[] args) {
        MaxSumSubmatrix maxSumSubmatrix = new MaxSumSubmatrix();
        int[][] param = new int[][]{
                {5, -4, -3, 4},
                {-3, -4, 4, 5},
                {5, 1, 5, -4}
        };
        System.out.println(maxSumSubmatrix.maxSumSubmatrix(param, 10));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        Integer result = null;
        //枚举上下边界
        for (int i = 0; i < matrix.length; i++) {
            int[] s = new int[matrix[i].length];
            for (int j = i; j < matrix.length; j++) {
                int[] ints = matrix[j];
                //枚举行获取每列的和，并将其叠加成递增的前面矩形整数和
                for (int l = 0; l < ints.length; l++) {
                    int one = matrix[j][l];
                    s[l] += one;
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int square = 0;
                for (int v : s) {
                    square += v;
                    Integer ceil = sumSet.ceiling(square - k);
                    if (ceil != null) {
                        if (result == null) {
                            result = square - ceil;
                        } else {
                            result = Math.max(result, square - ceil);
                        }
                    }
                    sumSet.add(square);
                }
            }
        }
        return result == null ? -1 : result;
    }

    /**
     * 不能用二分法查找，因为有负数，面积不一定是递增
     * @param nums
     * @param target
     * @return
     */
    private int search(int[] nums, int target) {
        if (nums[0] > target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
