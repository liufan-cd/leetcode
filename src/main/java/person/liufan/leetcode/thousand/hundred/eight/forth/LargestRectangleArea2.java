package person.liufan.leetcode.thousand.hundred.eight.forth;

import java.util.Stack;

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
public class LargestRectangleArea2 {
    public static void main(String[] args) {
        LargestRectangleArea2 largestRectangleArea = new LargestRectangleArea2();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2,1,2}));
    }
    /**
     * 单调栈
     * 我们要寻找的就是小于当前元素的第一个坐标
     * 在遍历的时候
     * 数组右边的元素小于左边元素，那么左边的元素一定不会是之前区间中最小的元素，这时就应该将其弹出，插入右边元素
     * 插入元素，再向前比较，维护小于的右边界，
     * 如
     * 1,2，100,100,1000,3
     * 维护的栈内存必定为
     * 1,2,3，这时最后一个元素为2，那么寻找的一定是1，然后压入2，
     */
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
