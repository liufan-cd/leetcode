package person.liufan.offer.twentynine;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentynine
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @date 2021/5/16
 */
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
    }

    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new int[]{};
        }
        int m = matrix[0].length;
        if (m == 0) {
            return new int[]{};
        }
        int[] ans = new int[m * n];
        Machine machine = new Machine(0, n - 1, 0, m - 1, 0, 0, matrix);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[machine.x][machine.y];
            machine.move();
        }
        return ans;
    }

    private class Machine {
        int up,down,left, right;
        int y, x;
        int[][] matrix;
        int weaning = 0;
        public Machine(int up, int down, int left, int right, int x, int y, int[][] matrix) {
            this.up = up;
            this.down = down;
            this.right = right;
            this.left = left;
            this.x = x;
            this.y = y;
            this.matrix = matrix;
        }

        public int getVal() {
            return matrix[x][y];
        }

        public void move() {
            if (left > right || up > down) {
                return;
            }
            switch (weaning % 4) {
                case 0:
                    if (y < right) {
                        y++;
                    } else {
                        up++;
                        weaning++;
                        move();
                    }
                    break;
                case 1:
                    if (x < down) {
                        x++;
                    } else {
                        right--;
                        weaning++;
                        move();
                    }
                    break;
                case 2:
                    if (y > left) {
                        y--;
                    } else {
                        down--;
                        weaning++;
                        move();
                    }
                    break;
                default:
                    if (x > up) {
                        x--;
                    } else {
                        left++;
                        weaning++;
                        move();
                    }
            }
        }
    }
}
