package person.liufan.leetcode.zero.zero.seven.ninth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.ninth
 * @description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class Exist {
    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }

    String target;
    char[][] board;
    boolean[][] flag;
    public boolean exist(char[][] board, String word) {
        this.target = word;
        this.board = board;
        this.flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == target.charAt(0)) {
                    flag[i][j] = true;
                    if (dfs(i, j, 1)) {
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int index) {
        if (index == target.length()) {
            return true;
        }
        if (up(i, j, target.charAt(index))) {
            flag[i][j - 1] = true;
            if (dfs(i, j - 1, index + 1)) {
                return true;
            }
            flag[i][j - 1] = false;
        }
        if (down(i, j, target.charAt(index))) {
            flag[i][j + 1] = true;
            if (dfs(i, j + 1, index + 1)) {
                return true;
            }
            flag[i][j + 1] = false;
        }
        if (left(i, j, target.charAt(index))) {
            flag[i - 1][j] = true;
            if (dfs(i - 1, j, index + 1)) {
                return true;
            }
            flag[i - 1][j] = false;
        }
        if (right(i, j, target.charAt(index))) {
            flag[i + 1][j] = true;
            if (dfs(i + 1, j, index + 1)) {
                return true;
            }
            flag[i + 1][j] = false;
        }
        return false;
    }

    public boolean up(int i, int j, char c) {
        if (colOut(j - 1) || flag[i][j - 1]) {
            return false;
        } else {
            return board[i][j - 1] == c;
        }
    }

    public boolean down(int i, int j, char c) {
        if (colOut(j + 1) || flag[i][j + 1]) {
            return false;
        } else {
            return board[i][j + 1] == c;
        }
    }

    public boolean left(int i, int j, char c) {
        if (rowOut(i - 1) || flag[i - 1][j]) {
            return false;
        } else {
            return board[i - 1][j] == c;
        }
    }

    public boolean right(int i, int j, char c) {
        if (rowOut(i + 1) || flag[i + 1][j]) {
            return false;
        } else {
            return board[i + 1][j] == c;
        }
    }

    public boolean rowOut(int i) {
        return !(i >= 0 && i < board.length);
    }

    public boolean colOut(int j) {
        return !(j >= 0 && j < board[0].length);
    }
}
