package person.liufan.leetcode.zero.three.nine.six;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.nine.six
 * @description:
 * 给定一个长度为 n 的整数数组 nums 。
 *
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 *
 * 生成的测试用例让答案符合 32 位 整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-function
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/22
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        MaxRotateFunction maxRotateFunction = new MaxRotateFunction();
        System.out.println(maxRotateFunction.maxRotateFunction(new int[]{4,3,2,6}));
    }
    public int maxRotateFunction(int[] nums) {
        // 遍历求第一个旋转函数和 rotateAll
        // 同时求前缀和all
        int rotateAll = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            rotateAll += i * nums[i];
            prefix += nums[i];
        }
        int ans = Integer.MIN_VALUE;
        // 遍历顺序，倒叙遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            // 下一个rotateAll为当前rotateAll
            rotateAll = rotateAll - nums[i] * (nums.length - 1) + (prefix - nums[i]);
            ans = Math.max(ans, rotateAll);
        }

        return ans;
    }
}
