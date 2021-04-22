package person.liufan.leetcode.thousand.hundred.five.forth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.forth
 * @description:
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @date 2021/4/2
 */
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        //System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //System.out.println(spiralOrder.spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    String status = "right";
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        int rowSize = matrix[0].length;
        boolean[][] isUsed = new boolean[n][rowSize];
        int i = 0, j = -1;
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            if ("right".equals(status)) {
                if (j + 1 == rowSize || isUsed[i][j + 1]) {
                    status = "down";
                } else {
                    isUsed[i][++j] = true;
                    result.add(matrix[i][j]);
                }
            } else if ("down".equals(status)) {
                if (i + 1 == n || isUsed[i + 1][j]) {
                    status = "left";
                } else {
                    isUsed[++i][j] = true;
                    result.add(matrix[i][j]);
                }
            } else if ("left".equals(status)) {
                if (j == 0 || isUsed[i][j - 1]) {
                    status = "up";
                } else {
                    isUsed[i][--j] = true;
                    result.add(matrix[i][j]);
                }
            } else if ("up".equals(status)) {
                if (i == 0 || isUsed[i - 1][j]) {
                    status = "right";
                } else {
                    isUsed[--i][j] = true;
                    result.add(matrix[i][j]);
                }
            }
            if ((i + 1 == n || isUsed[i + 1][j])
                    && (j + 1 == rowSize || isUsed[i][j + 1])
                    && (i == 0 || isUsed[i - 1][j])
                    && (j == 0 || isUsed[i][j - 1])) {
                break;
            }
        }
        return result;
    }
}
