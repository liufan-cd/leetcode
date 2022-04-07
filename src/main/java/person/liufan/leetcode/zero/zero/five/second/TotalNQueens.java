package person.liufan.leetcode.zero.zero.five.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.first
 * @description:
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/1
 */
public class TotalNQueens {
    public static void main(String[] args) {
        TotalNQueens solveNQueens = new TotalNQueens();
        System.out.println(solveNQueens.totalNQueens(4));
    }

    int result = 0;
    public int totalNQueens(int n) {
        boolean[][] isUsed = new boolean[n][n];
        dfs(0, n, isUsed);
        return result;
    }

    private void dfs(int index, int n, boolean[][] isUsed) {
        if (index == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isRight(index, i, n, isUsed)) {
                isUsed[index][i] = true;
                dfs(index + 1, n, isUsed);
                isUsed[index][i] = false;
            }
        }
    }
    private boolean isRight(int row, int col, int n, boolean[][] isUsed) {
        for (int i = 0; i < row; i++) {
            if (isUsed[i][col]) {
                return false;
            }
            if ((col - (row - i)) >= 0 && isUsed[i][col - (row - i)]) {
                return false;
            }
            if (((row - i) + col) < n && isUsed[i][(row - i) + col]) {
                return false;
            }
        }
        return true;
    }
}
