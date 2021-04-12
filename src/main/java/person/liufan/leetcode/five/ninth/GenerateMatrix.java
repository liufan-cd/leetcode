package person.liufan.leetcode.five.ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.five.ninth
 * @description: TODO
 * @date 2021/4/2
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] param = generateMatrix.generateMatrix(5);
        for (int i = 0; i < param.length; i++) {
            int[] ints = param[i];
            for (int j = 0; j < ints.length; j++) {
                int a = ints[j];
                System.out.print(a + "\t");
            }
            System.out.println("\t");
        }
    }
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int total = n * n;
        int size = 1;
        int i = -1, j = -1;
        int[][] result = new int[n][n];
        while (size < total) {
            i++;
            j++;
            int tempI = i, tempJ = j;
            for (; j < n - 1 - tempJ; j++) {
                result[i][j] = size;
                size++;
            }
            for (; i < n - 1 - tempI; i++) {
                result[i][j] = size;
                size++;
            }
            for (; j > tempJ; j--) {
                result[i][j] = size;
                size++;
            }
            for (; i > tempI; i--) {
                result[i][j] = size;
                size++;
            }
        }
        if (n % 2 != 0) {
            result[++i][++j] = size;
        }
        return result;
    }
}
