package person.liufan.leetcode.zero.zero.eight.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.eight.forth
 * @description:
 *
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @date 2021/4/8
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{1,2,3,4,5}));
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int right = 0;
            int left = 0;
            int j = 0;
            for (; i + j < heights.length; j++) {
                if (heights[i + j] < heights[i]) {
                    break;
                }
            }
            right = j * heights[i];
            j = 1;
            for (; i - j >= 0; j++) {
                if (heights[i - j] < heights[i]) {
                    break;
                }
            }
            left = (j - 1) * heights[i];
            maxArea = Math.max(left + right, maxArea);
        }
        return maxArea;
    }
}
