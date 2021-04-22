package person.liufan.middle.tree;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.tree
 * @description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvtsnm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/19
 */
public class NumIslands {
    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        /*char[][] param = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };*/
        /*char[][] param = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };*/
        char[][] param = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };
        System.out.println(numIslands.numIslands(param));
    }

    boolean[][] isSea;
    char[][] grid;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        isSea = new boolean[grid.length][grid[0].length];
        int size = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == '1' && !isSea[i][j]) {
                    setIsSea(i, j);
                    isSea[i][j] = false;
                    size++;
                } else {
                    isSea[i][j] = true;
                }
            }
        }
        return size;
    }

    public void setIsSea(int i, int j) {
        if (i < 0 || i >= isSea.length) {
            return;
        }
        if (j < 0 || j >= isSea[0].length) {
            return;
        }
        if (grid[i][j] == '1' && !isSea[i][j]) {
            isSea[i][j] = true;
            setIsSea(i - 1, j);
            setIsSea(i, j - 1);
            setIsSea(i, j + 1);
            setIsSea(i + 1, j);
        }
    }
}
