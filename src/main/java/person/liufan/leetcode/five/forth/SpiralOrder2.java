package person.liufan.leetcode.five.forth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.five.forth
 * @description:
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @date 2021/4/2
 */
public class SpiralOrder2 {
    public static void main(String[] args) {
        SpiralOrder2 spiralOrder = new SpiralOrder2();
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //System.out.println(spiralOrder.spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        int m = matrix[0].length;
        int total = n * m;
        int size = 0;
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (size < total) {
            int tempI = i, tempJ = j;
            for (; j < m - 1 - tempJ; j++) {
                result.add(matrix[i][j]);
                size++;
            }
            for (; i < n - 1 - tempI && size < total; i++) {
                result.add(matrix[i][j]);
                size++;
            }
            for (; j > tempJ && size < total; j--) {
                result.add(matrix[i][j]);
                size++;
            }
            for (; i > tempI && size < total; i--) {
                result.add(matrix[i][j]);
                size++;
            }
            i++;
            j++;
            result.add(matrix[i][j]);
            size++;
        }
        return result;
    }
}
