package person.liufan.leetcode.zero.four.two.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.two.one
 * @description:
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/16
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{3,10,5,25,2,8}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{0}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{2,4}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{8,10,2}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }

    private static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            // 从最高位开始进行确定最大值
            // 假如所有都是1位数，判断是否可以为最大值是否可以为1
            // 然后就可以知道2位数的时候是否可以为，x1，一直判断下去
            Set<Integer> set = new HashSet<>();
            ans <<= 1;
            for (int num : nums) {
                set.add(num >> i);
            }
            for (Integer integer : set) {
                if (set.contains((ans + 1) ^ integer)) {
                    ans = ans + 1;
                    break;
                }
            }
        }
        return ans;
    }
}
