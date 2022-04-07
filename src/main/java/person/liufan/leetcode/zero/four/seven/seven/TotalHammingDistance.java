package person.liufan.leetcode.zero.four.seven.seven;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.seven.seven
 * @description:
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * @date 2021/5/28
 */
public class TotalHammingDistance {
    public static void main(String[] args) {

    }
    public int totalHammingDistance(int[] nums) {
        int[] bits = new int[32];
        int n = nums.length;
        for (int num : nums) {
            for (int i = 0; i < bits.length; i++) {
                bits[i] += num >>> i & 1;
            }
        }
        int ans = 0;
        for (int bit : bits) {
            ans += bit * (n - bit);
        }
        return ans;
    }
}
