package person.liufan.leetcode.thousand.hundred.third.sixth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.sixth
 * @description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/27
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(
                new char[][]{
                        new char[]{'5','3','.','.','7','.','.','.','.'},
                        new char[]{'6','.','.','1','9','5','.','.','.'},
                        new char[]{'.','9','8','.','.','.','.','6','.'},
                        new char[]{'8','.','.','.','6','.','.','.','3'},
                        new char[]{'4','.','.','8','.','3','.','.','1'},
                        new char[]{'7','.','.','.','2','.','.','.','6'},
                        new char[]{'.','6','.','.','.','.','2','8','.'},
                        new char[]{'.','.','.','4','1','9','.','.','5'},
                        new char[]{'.','.','.','.','8','.','.','7','9'}
                }
        ));
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Map<Character, Object>> squareMap = new HashMap<>();
        Map<Integer, Map<Character, Object>> columnMap = new HashMap<>();
        Map<Integer, Map<Character, Object>> rowMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (isContains(rowMap, i, aChar)) {
                    return false;
                }
                if (isContains(columnMap, j, aChar)) {
                    return false;
                }
                if (isContains(squareMap, (i / 3 * 3 + j / 3 + 1), aChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isContains(Map<Integer, Map<Character, Object>> map, Integer index, char c) {
        Map<Character, Object> chars = map.get(index);
        if (c == '.') {
            return false;
        }
        if (chars == null) {
            chars = new HashMap<>();
            map.put(index, chars);
        }
        if (chars.containsKey(c)) {
            return true;
        } else {
            chars.put(c, null);
        }
        return false;
    }
}
