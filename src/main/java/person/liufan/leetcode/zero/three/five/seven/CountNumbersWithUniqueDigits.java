package person.liufan.leetcode.zero.three.five.seven;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.five.seven
 * @description:
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * @date 2022/4/11
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2));
    }
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 0;
        if (n == 0) {
            return 1;
        }
        // 首位是0
        ans += countNumbersWithUniqueDigits(n - 1);
        // 首位不是0
        // sum = 9 * 9 * 8 * 7....
        int sum = 9;
        while (--n != 0) {
            sum *= 10 - n;
        }
        ans += sum;
        return ans;
    }
}
