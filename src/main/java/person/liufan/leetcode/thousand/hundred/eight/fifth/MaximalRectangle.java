package person.liufan.leetcode.thousand.hundred.eight.fifth;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.fifth
 * @description:
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @date 2021/4/8
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] temp1 = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == '1') {
                    if (j == 0) {
                        temp1[j][i] = 1;
                    } else {
                        temp1[j][i] = temp1[j - 1][i] + 1;
                    }
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < temp1.length; i++) {
            int[] ints = temp1[i];
            maxArea = Math.max(largestRectangleArea(ints), maxArea);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] leftArea = new int[n];
        Stack<Integer> mono_stack = new Stack<>();
        mono_stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (mono_stack.peek() != -1 && heights[mono_stack.peek()] >= height) {
                mono_stack.pop();
            }
            int left = mono_stack.peek();
            leftArea[i] = (i - left) * height;
            mono_stack.push(i);
        }
        mono_stack.clear();
        mono_stack.push(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            while (mono_stack.peek() != heights.length && heights[mono_stack.peek()] >= height) {
                mono_stack.pop();
            }
            int right = mono_stack.peek();
            maxArea = Math.max((right - i - 1) * height + leftArea[i], maxArea);
            mono_stack.push(i);
        }
        return maxArea;
    }
}
