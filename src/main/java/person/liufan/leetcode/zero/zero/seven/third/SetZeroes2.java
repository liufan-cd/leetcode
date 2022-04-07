package person.liufan.leetcode.zero.zero.seven.third;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.third
 * @description:
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class SetZeroes2 {
    public static void main(String[] args) {
        SetZeroes2 setZeroes2 = new SetZeroes2();
        int[][] param = new int[][]{
                /*{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}*/
                {0, 2},
                {1, 1}
        };
        setZeroes2.setZeroes(param);
        System.out.println(Arrays.deepToString(param));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row = true;
            }
        }
        for (int i = m - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                setRow(matrix, i);
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                setCol(matrix, j);
            }
        }
        if (row) {
            setRow(matrix, 0);
        }
        if (col) {
            setCol(matrix, 0);
        }
    }
    public void setRow(int[][] matrix, int row) {
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }
    public void setCol(int[][] matrix,int col) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
    }
}
