package person.liufan.advanced.array;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description: 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwk53e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/21
 */
public class GameOfLife {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        int[][] board = new int[][]{
                {1, 1},
                {1, 0}
        };
        /*int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };*/
        gameOfLife.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            int[] ints = board[i];
            for (int j = 0; j < ints.length; j++) {
                ints[j] += life(i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            int[] ints = board[i];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = ints[j] >> 1;
            }
        }
    }

    private int life(int i, int j) {
        int sum = getRoundCell(i, j);
        int current = board[i][j] & 1;
        switch (sum) {
            case 2:
                return current << 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    private int getRoundCell(int i, int j) {
        int sum = 0;
        sum += getStatus(i, j + 1);
        sum += getStatus(i, j - 1);
        sum += getStatus(i + 1, j - 1);
        sum += getStatus(i + 1, j);
        sum += getStatus(i + 1, j + 1);
        sum += getStatus(i - 1, j - 1);
        sum += getStatus(i - 1, j);
        sum += getStatus(i - 1, j + 1);
        return sum;
    }

    private int getStatus(int i, int j) {
        if (i >= 0 && i < board.length) {
            if (j >= 0 && j < board[i].length) {
                return board[i][j] & 1;
            }
        }
        return 0;
    }
}
