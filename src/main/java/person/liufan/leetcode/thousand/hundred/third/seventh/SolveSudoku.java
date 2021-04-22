package person.liufan.leetcode.thousand.hundred.third.seventh;

import java.util.ArrayList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.seventh
 * @description: TODO
 * @date 2021/3/27
 */
public class SolveSudoku {
    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
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
        solveSudoku.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                System.out.print(c);
            }
            System.out.println("");
        }
    }
    public void solveSudoku(char[][] board) {
        ArrayList<Character>[][] arrayLists = new ArrayList[9][9];
        ArrayList<Character> empty = new ArrayList<Character>() {{
            add('1');add('2');add('3');
            add('4');add('5');add('6');
            add('7');add('8');add('9');
        }};
        int change = 1;
        while (change++ > 0) {
            change = 0;
            for (int i = 0; i < board.length; i++) {
                char[] chars = board[i];
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    //判断list长度是否为1，是的话设置字符，不是跳过
                    if (c == '.') {
                        continue;
                    } else {
                        for (int temp = 0; temp < 9; temp++) {
                            if (board[i][temp] == '.') {
                                if (arrayLists[i][temp] == null) {
                                    arrayLists[i][temp] = new ArrayList<>(empty);
                                }
                                if (arrayLists[i][temp].contains(new Character(c))) {
                                    arrayLists[i][temp].remove(new Character(c));
                                    change++;
                                }
                            }
                            if (board[temp][j] == '.') {
                                if (arrayLists[temp][j] == null) {
                                    arrayLists[temp][j] = new ArrayList<>(empty);
                                }
                                if (arrayLists[temp][j].contains(new Character(c))) {
                                    arrayLists[temp][j].remove(new Character(c));
                                    change++;
                                }
                            }
                        }
                        int box = i / 3 * 3 + j / 3;
                        int column;
                        int row;
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                column = box % 3 * 3 + k;
                                row = box / 3 * 3 + l;
                                if (row == i && column == j) {
                                    continue;
                                }
                                if (board[row][column] == '.') {
                                    if (arrayLists[row][column] == null) {
                                        arrayLists[row][column] = new ArrayList<>(empty);
                                    }
                                    if (arrayLists[row][column].contains(new Character(c))) {
                                        arrayLists[row][column].remove(new Character(c));
                                        change++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                char[] chars = board[i];
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    //判断list长度是否为1，是的话设置字符，不是跳过
                    if (c == '.') {
                        if (arrayLists[i][j].size() == 1) {
                            board[i][j] = arrayLists[i][j].get(0);
                            change++;
                        }
                    }
                }
            }
        }
    }

    public boolean setRowColumnBox(char[][] board, ArrayList<Character>[][] arrayLists, ArrayList<Character> empty, int i, int j) {
        char c = board[i][j];
        for (int temp = 0; temp < 9; temp++) {
            if (board[i][temp] == '.') {
                if (arrayLists[i][temp] == null) {
                    arrayLists[i][temp] = new ArrayList<>(empty);
                }
                arrayLists[i][temp].remove(new Character(c));
                if (arrayLists[i][temp].size() == 1) {
                    board[i][temp] = arrayLists[i][temp].get(0);
                    setRowColumnBox(board, arrayLists, empty, i, temp);
                }
            } else if (board[i][temp] == c) {
                return false;
            }
            if (board[temp][j] == '.') {
                if (arrayLists[temp][j] == null) {
                    arrayLists[temp][j] = new ArrayList<>(empty);
                }
                arrayLists[temp][j].remove(new Character(c));
                if (arrayLists[temp][j].size() == 1) {
                    board[temp][j] = arrayLists[temp][j].get(0);
                    setRowColumnBox(board, arrayLists, empty, temp, j);
                }
            }
        }
        int box = i / 3 * 3 + j / 3;
        int column;
        int row;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                column = box % 3 + k;
                row = box / 3 * 3 + l;
                if (row == i && column == j) {
                    continue;
                }
                if (board[row][column] == '.') {
                    if (arrayLists[row][column] == null) {
                        arrayLists[row][column] = new ArrayList<>(empty);
                    }
                    arrayLists[row][column].remove(new Character(c));
                    if (arrayLists[row][column].size() == 1) {
                        board[row][column] = arrayLists[row][column].get(0);
                        setRowColumnBox(board, arrayLists, empty, row, column);

                    }
                }
            }
        }
        return false;
    }
}
