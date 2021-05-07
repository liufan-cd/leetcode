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
public class MovingCount2 {
    public static void main(String[] args) {
        MovingCount2 movingCount = new MovingCount2();
        System.out.println(movingCount.movingCount(3, 1, 0));
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] isUsed = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (isRightLocation(k, m, n, current, isUsed)) {
                queue.offer(new int[]{current[0] + 1, current[1]});
                queue.offer(new int[]{current[0] - 1, current[1]});
                queue.offer(new int[]{current[0], current[1] + 1});
                queue.offer(new int[]{current[0], current[1] - 1});
                ans++;
            }
        }
        return ans;
    }

    private boolean isRightLocation(int k, int m, int n, int[] location, boolean[][] isUsed) {
        int row = location[0];
        int column = location[1];
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
                    isUsed[location[0]][location[1]] = true;
                    return true;
                }
            }
        }
        return false;
    }
}