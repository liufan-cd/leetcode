package person.liufan.leetcode.zero.zero.seven.third;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.third
 * @description: TODO
 * @date 2021/4/7
 */
public class SetZeroes {
    public static void main(String[] args) {

    }
    /**
     * O(mn)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flags = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    flags[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flags[i][j]) {
                    setZeroes(matrix,i,j);
                }
            }
        }
    }

    public void setZeroes(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
    }
}
