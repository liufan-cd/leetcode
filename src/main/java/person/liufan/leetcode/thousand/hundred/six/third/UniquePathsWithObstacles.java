package person.liufan.leetcode.thousand.hundred.six.third;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.third
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(
                /*new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }*/
                new int[][]{
                        {0, 1},
                        {0, 0}
                }
        ));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m + 1][n + 1];
        result[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = result[i][j - 1];
                int up = result[i - 1][j];
                if (j - 2 >= 0 && obstacleGrid[i - 1][j - 2] == 1) {
                    left = 0;
                }
                if (i - 2 >= 0 && obstacleGrid[i - 2][j - 1] == 1) {
                    up = 0;
                }
                result[i][j] = left + up;
            }
        }
        return obstacleGrid[m - 1][n - 1] == 0 ? result[m][n] : 0;
    }
}
