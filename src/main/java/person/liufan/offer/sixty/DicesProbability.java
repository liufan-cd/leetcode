package person.liufan.offer.sixty;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixty
 * @description:
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/23
 */
public class DicesProbability {
    public static void main(String[] args) {
        DicesProbability dicesProbability = new DicesProbability();
        System.out.println(Arrays.toString(dicesProbability.dicesProbability(2)));
    }

    /**
     * 1 2 3 4 5 6
     * 2 3 4 5 6 7 8 9 10 11 12
     * 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
     * 1 2
     */
    public double[] dicesProbability(int n) {
        double[] ans = new double[5 * n + 1];
        int[] dp;
        int[] pre = new int[1];
        pre[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp = new int[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                dp[j] = preSum(pre, j);
            }
            if (i == n) {
                transform(dp, ans);
                return ans;
            }
            pre = dp;
        }
        return ans;
    }

    public int preSum(int[] pre, int n) {
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (n - i >= 0 && n - i < pre.length) {
                ans += pre[n - i];
            }
        }
        return ans;
    }

    public void transform(int[] dp, double[] ans) {
        int sum = 0;
        for (int j : dp) {
            sum += j;
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (double) dp[i]/sum;
        }
    }
}
