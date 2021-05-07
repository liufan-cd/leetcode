package person.liufan.offer.thirteen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirteen
 * @description:
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/7
 */
public class MovingCount {
    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(3, 1, 0));
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] isUsed = new boolean[m][n];
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0));
        int ans = 0;
        while (!queue.isEmpty()) {
            Location current = queue.poll();
            if (isRightLocation(k, m, n, current, isUsed)) {
                queue.offer(new Location(current.row - 1, current.column));
                queue.offer(new Location(current.row + 1, current.column));
                queue.offer(new Location(current.row, current.column - 1));
                queue.offer(new Location(current.row, current.column + 1));
                ans++;
            }
        }
        return ans;
    }

    private boolean isRightLocation(int k, int m, int n, Location location, boolean[][] isUsed) {
        int row = location.row;
        int column = location.column;
        if (row >= 0 && row < m && column >= 0 && column < n) {
            if (!isUsed[row][column]) {
                int sum = 0;
                while (row != 0) {
                    sum += row % 10;
                    row /= 10;
                }
                while (column != 0) {
                    sum += column % 10;
                    column /= 10;
                }
                if (sum <= k) {
                    isUsed[location.row][location.column] = true;
                    return true;
                }
            }
        }
        return false;
    }
    private class Location{
        int row;
        int column;
        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}