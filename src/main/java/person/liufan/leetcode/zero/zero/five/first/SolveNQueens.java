package person.liufan.leetcode.zero.zero.five.first;

import java.util.ArrayList;
import java.util.List;

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
public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        solveNQueens.solveNQueens(4).forEach(list -> {
            list.forEach(s -> {
                System.out.println(s + "\t");
            });
            System.out.println("===============");
        });
    }

    List<List<String>> results = new ArrayList<>();
    List<String> combine = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] isUsed = new boolean[n][n];
        dfs(0, n, isUsed);
        return results;
    }

    private void dfs(int index, int n, boolean[][] isUsed) {
        if (index == n) {
            //TODO 保存
            results.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < n; i++) {
            //TODO 第index个，遍历数组
            //合理，标记，组合
            //下一个搜索
            if (isRight(index, i, n, isUsed)) {
                isUsed[index][i] = true;
                combine.add(generateString(i, n));
                dfs(index + 1, n, isUsed);
                combine.remove(combine.size() - 1);
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

    private String generateString(int i, int n) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < n; j++) {
            builder.append(".");
        }
        builder.replace(i, i + 1, "Q");
        return builder.toString();
    }
}
