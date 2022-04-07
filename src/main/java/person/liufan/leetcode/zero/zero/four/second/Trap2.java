package person.liufan.leetcode.zero.zero.four.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.second
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2021/3/31
 */
public class Trap2 {
    public static void main(String[] args) {
        Trap2 trap = new Trap2();
        System.out.println(trap.trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 这个双指针是真的牛逼
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                }
                sum += leftMax - height[left];
                left++;
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                }
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

}
