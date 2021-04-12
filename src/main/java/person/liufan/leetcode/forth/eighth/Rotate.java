package person.liufan.leetcode.forth.eighth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.forth.eighth
 * @description: TODO
 * @date 2021/4/1
 */
public class Rotate {
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] para = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        for (int i = 0; i < para.length; i++) {
            int[] ints = para[i];
            for (int j = 0; j < ints.length; j++) {
                int a = ints[j];
                System.out.print(a + "\t");
            }
            System.out.println(" ");
        }
        rotate.rotate(para);
        System.out.println("++++++++++++++++");
        for (int i = 0; i < para.length; i++) {
            int[] ints = para[i];
            for (int j = 0; j < ints.length; j++) {
                int a = ints[j];
                System.out.print(a + "\t");
            }
            System.out.println(" ");
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                rotate(matrix, i, j);
            }
        }
    }
    private void rotate(int[][] matrix, int x, int y) {
        int n = matrix.length - 1;
        int temp = matrix[n - y][x];
        matrix[n - y][x] = matrix[n - x][n - y];
        matrix[n - x][n - y] = matrix[y][n - x];
        matrix[y][n - x] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
