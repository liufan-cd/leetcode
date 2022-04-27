package person.liufan.leetcode.zero.four.one.seven;

import person.liufan.common.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.four.one.seven
 * @description:
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/27
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        System.out.println(pacificAtlantic.pacificAtlantic(ArrayUtils.parseTwoArray("[[1,1],[1,1],[1,1]]")));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        byte[][] temp = new byte[heights.length][heights[0].length];
        LinkedList<BinaryNode> queue = new LinkedList<>();
        for (int i = 0; i < heights[0].length; i++) {
            queue.offerLast(new BinaryNode(i, 0));
        }

        for (int j = 0; j < heights.length; j++) {
            queue.offerLast(new BinaryNode(0, j));
        }

        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.pollFirst();
            int x = binaryNode.getX();
            int y = binaryNode.getY();
            if (temp[y][x] == 1) {
                continue;
            }
            temp[y][x] = 1;
            addNext(heights, queue, x, y);
        }

        for (int i = 0; i < heights[0].length; i++) {
            queue.offerLast(new BinaryNode(i, heights.length - 1));
        }

        for (int j = 0; j < heights.length; j++) {
            queue.offerLast(new BinaryNode(heights[0].length - 1, j));
        }

        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.pollFirst();
            int x = binaryNode.getX();
            int y = binaryNode.getY();
            if (temp[y][x] >> 1 == 1) {
                continue;
            }
            temp[y][x] += 2;
            addNext(heights, queue, x, y);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < temp.length; i++) {
            byte[] bytes = temp[i];
            for (int j = 0; j < bytes.length; j++) {
                byte aByte = bytes[j];
                if (aByte == 3) {
                    List<Integer> integers = new ArrayList<>();
                    ans.add(integers);
                    integers.add(i);
                    integers.add(j);
                }
            }
        }
        return ans;
    }

    private void addNext(int[][] heights, LinkedList<BinaryNode> queue, int x, int y) {
        if (x > 0) {
            if (heights[y][x - 1] >= heights[y][x]) {
                queue.offerLast(new BinaryNode(x - 1, y));
            }
        }
        if (y > 0) {
            if (heights[y - 1][x] >= heights[y][x]) {
                queue.offerLast(new BinaryNode(x, y - 1));
            }
        }
        if (x + 1 < heights[0].length) {
            if (heights[y][x + 1] >= heights[y][x]) {
                queue.offerLast(new BinaryNode(x + 1, y));
            }
        }
        if (y + 1 < heights.length) {
            if (heights[y + 1][x] >= heights[y][x]) {
                queue.offerLast(new BinaryNode(x, y + 1));
            }
        }
    }

    private static class BinaryNode {
        private final int[] val;

        private BinaryNode(int x, int y) {
            val = new int[]{x, y};
        }

        private int getX() {
            return val[0];
        }

        private int getY() {
            return val[1];
        }
    }
}
