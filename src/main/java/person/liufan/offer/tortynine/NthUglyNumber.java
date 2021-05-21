package person.liufan.offer.tortynine;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.tortynine
 * @description:
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @date 2021/5/20
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int twoIndex = 1;
        int threeIndex = 1;
        int fiveIndex = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(Math.min(dp[twoIndex] * 2, dp[threeIndex] * 3), dp[fiveIndex] * 5);
            if (dp[i] == dp[twoIndex] * 2) {
                twoIndex++;
            }
            if (dp[i] == dp[threeIndex] * 3) {
                threeIndex++;
            }
            if (dp[i] == dp[fiveIndex] * 5) {
                fiveIndex++;
            }
        }
        return dp[n];
    }
}
