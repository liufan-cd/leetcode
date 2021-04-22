package person.liufan.leetcode.thousand.hundred.five.fifth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.fifth
 * @description:
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * @date 2021/4/2
 */
public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2,0,0}));
    }
    public boolean canJump(int[] nums) {
        int left = 0;
        int n = nums.length;
        for (int i = 0; i <= left && i < n; i++) {
            left = Math.max(left, i + nums[i]);
        }
        return left >= n - 1;
    }
}
