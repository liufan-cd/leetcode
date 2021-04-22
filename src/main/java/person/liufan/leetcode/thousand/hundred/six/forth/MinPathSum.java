package person.liufan.leetcode.thousand.hundred.six.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.forth
 * @description:
 *
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
 * @date 2021/4/6
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(new int[][]{
                /*{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}*/
                {1, 2, 3},
                {4, 5, 6}
        }));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - 1 >= 0 ? result[i][j - 1] : Integer.MAX_VALUE;
                int up = i - 1 >= 0 ? result[i - 1][j] : Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    result[0][0] = grid[0][0];
                } else {
                    result[i][j] = Math.min(left, up) + grid[i][j];
                }

            }
        }
        return result[m-1][n-1];
    }
}
