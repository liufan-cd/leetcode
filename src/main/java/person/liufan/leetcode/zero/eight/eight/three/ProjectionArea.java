package person.liufan.leetcode.zero.eight.eight.three;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.eight.eight.three
 * @description:
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 *
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/projection-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/26
 */
public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        // 俯视
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    ans++;
                }
            }
        }

        for (int[] ints : grid) {
            int row = 0;
            for (int anInt : ints) {
                row = Math.max(row, anInt);
            }
            ans += row;
        }

        for (int j = 0; j < grid[0].length; j++) {
            int row = 0;
            for (int[] ints : grid) {
                row = Math.max(row, ints[j]);
            }
            ans += row;
        }

        return ans;
    }
}
