package person.liufan.leetcode.one.zero.seven.four;


import person.liufan.common.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.zero.seven.four
 * @description:
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/29
 */
public class NumSubmatrixSumTarget {
    public static void main(String[] args) {
        NumSubmatrixSumTarget numSubmatrixSumTarget = new NumSubmatrixSumTarget();
        int[][] matrix = ArrayUtils.parseTwoArray("[[0,1,0],[1,1,1],[0,1,0]]");
        System.out.println(numSubmatrixSumTarget.numSubmatrixSumTarget(matrix, 1));
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // 计算所有列的前缀和
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 1; i < matrix.length; i++) {
            int[] ints = matrix[i];
            for (int j = 0; j < ints.length; j++) {
                ints[j] += matrix[i - 1][j];
            }
        }
        // 枚举上下边界
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                // 缓存数组
                int[] temp = new int[n];
                for (int k = 0; k < temp.length; k++) {
                    temp[k] += matrix[j][k];
                    int upValue = i == 0 ? 0 : matrix[i - 1][k];
                    temp[k] -= upValue;
                }
                System.out.println();
                // 求缓存数组的和为target的子数组个数
                // 数组的前缀和
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int per = 0;
                for (int k = 0; k < temp.length; k++) {
                    per += temp[k];
                    ans += map.getOrDefault(per - target, 0);
                    map.merge(per, 1, Integer::sum);
                }
            }
        }
        return ans;
    }

}
