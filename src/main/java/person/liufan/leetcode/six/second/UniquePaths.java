package person.liufan.leetcode.six.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.six.second
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 1));
    }
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m + 1][n + 1];
        result[0][1] = 1;
        for (int i = 1; i < result.length; i++) {
            int[] ints = result[i];
            for (int j = 1; j < ints.length; j++) {
                ints[j] = ints[j - 1] + result[i - 1][j];
            }
        }
        return result[m][n];
    }
}
