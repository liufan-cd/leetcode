package person.liufan.primary.dp;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.dp
 * @description:
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/15
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7}));
    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i] - prices[i - 1] + temp;
            if (price < 0) {
                temp = 0;
            } else {
                temp = price;
                maxProfit = Math.max(maxProfit, temp);
            }
        }
        return maxProfit;
    }
}
