package person.liufan.middle.dp;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.dp
 * @description:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/20
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        //System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{1,2147483647}, 2));
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] result = new int[amount + 1];
        for (int coin : coins) {
            if (coin >= result.length) {
                continue;
            }
            result[coin] = 1;
        }
        for (int i = 1; i < result.length; i++) {
            int coinNum = result[i];
            if (coinNum == 0) {
                continue;
            }
            for (int coin : coins) {
                if (i + coin >= result.length || i + coin < 0) {
                    continue;
                }
                if (result[i + coin] != 0) {
                    result[i + coin] = Math.min(result[i + coin], coinNum + 1);
                } else {
                    result[i + coin] = coinNum + 1;
                }
            }
        }
        return result[amount] == 0 ? -1 : result[amount];
    }
}
