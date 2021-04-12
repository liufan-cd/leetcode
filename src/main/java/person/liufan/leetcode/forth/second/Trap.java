package person.liufan.leetcode.forth.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.forth.second
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2021/3/31
 */
public class Trap {
    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{}));
        //int[] max = trap.findMax(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 1, 0);
        //System.out.println(max[0] + "" + max[1]);
    }
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] max = findMax(height, 0, height.length - 1);
        int sum = 0;
        //定义左部分的右边界
        int lr = max[0] - 1;
        while (lr > 0) {
            int[] left = findMax(height, 0, lr);
            sum += sum(height, left[0], lr, left[1]);
            lr = left[0] - 1;
        }
        int rl = max[0] + 1;
        while (rl < height.length - 1) {
            int[] right = findMax(height, rl, height.length - 1);
            sum += sum(height, rl, right[0], right[1]);
            rl = right[0] + 1;
        }
        return sum;
    }

    private int sum(int[] height, int offset, int end, int max) {
        int sum = 0;
        if (offset > end) {
            return sum(height, end, offset, max);
        }
        for (int i = offset; i <= end; i++) {
            if (max >= height[i]) {
                sum += max - height[i];
            }
        }
        return sum;
    }

    private int[] findMax(int[] height, int offset, int end) {
        if (offset > end) {
            return findMax(height, end, offset);
        }
        int temp = height[offset];
        int index = offset;
        for (int i = offset; i <= end; i++) {
            if (temp < height[i]) {
                temp = height[i];
                index = i;
            }
        }
        return new int[]{index, temp};
    }
}
