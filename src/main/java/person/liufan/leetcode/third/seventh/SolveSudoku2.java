package person.liufan.leetcode.third.seventh;

import java.util.ArrayList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.third.seventh
 * @description:
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * 提示：
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * @date 2021/3/27
 */
public class SolveSudoku2 {
    public static void main(String[] args) {
        SolveSudoku2 solveSudoku = new SolveSudoku2();
        char[][] board = new char[][]{
                new char[]{'.','.','9','7','4','8','.','.','.'},
                new char[]{'7','.','.','.','.','.','.','.','.'},
                new char[]{'.','2','.','1','.','9','.','.','.'},
                new char[]{'.','.','7','.','.','.','2','4','.'},
                new char[]{'.','6','4','.','1','.','5','9','.'},
                new char[]{'.','9','8','.','.','.','3','.','.'},
                new char[]{'.','.','.','8','.','3','.','2','.'},
                new char[]{'.','.','.','.','.','.','.','.','6'},
                new char[]{'.','.','.','2','7','5','9','.','.'}
        };
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                System.out.print(c+"  ");
            }
            System.out.println("");
        }
        System.out.println("======================");
        solveSudoku.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                System.out.print(c+"  ");
            }
            System.out.println("");
        }
    }

    private boolean[][] row = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] box = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == '.') {
                    continue;
                } else {
                    row[i][c - '0' - 1] = true;
                    column[j][c - '0' - 1] = true;
                    box[i / 3][j / 3][c - '0' - 1] = true;
                }
            }
        }
        int count = 0;
        solve(board, 0);
    }

    public boolean solve(char[][] board, int index) {
        if (index == 81) {
            return true;
        }
        int i = parseIndex(index)[0];
        int j = parseIndex(index)[1];
        if (board[i][j] != '.'){
            return solve(board, index + 1);
        }
        for (int k = 1; k < 10; k++) {
            if (isBlock(i, j, k)) {
                continue;
            }else {
                board[i][j] = (char) ('0' + k);
                setBlock(i, j, k);
                if (solve(board, index + 1)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    removeBlock(i, j, k);
                }
            }
        }
        return false;
    }
    private int[] parseIndex(int index) {
        return new int[]{index / 9, index % 9};
    }

    private boolean isBlock(int i, int j, int number) {
        boolean flag = row[i][number - 1] ||
                column[j][number - 1] ||
                box[i / 3][j / 3][number - 1];
        return flag;
    }

    private void setBlock(int i, int j, int number) {
        row[i][number - 1] = true;
        column[j][number - 1] = true;
        box[i / 3][j / 3][number - 1] = true;
    }

    private void removeBlock(int i, int j, int number) {
        row[i][number - 1] = false;
        column[j][number - 1] = false;
        box[i / 3][j / 3][number  - 1] = false;
    }
}
