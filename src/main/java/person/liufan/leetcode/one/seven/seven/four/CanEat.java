package person.liufan.leetcode.one.seven.seven.four;

import person.liufan.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.seven.seven.four
 * @description:
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/1
 */
public class CanEat {
    public static void main(String[] args) {
        CanEat canEat = new CanEat();
        int[][] param = ArrayUtils.parseTwoArray("[[2,2,6]]");
        int[] param1 = new int[]{7,11,5,3,8};
        System.out.println(Arrays.toString(canEat.canEat(param1, param)));
    }


    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] preSum = new long[candiesCount.length];
        preSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = canEat(preSum, query);
        }
        return ans;
    }

    public boolean canEat(long[] preSum, int[] query) {
        long left = query[1];
        long right = ((long) query[1] + 1) * (long) query[2];
        long candySum = preSum[query[0]];
        long preCandySum = query[0] == 0 ? 0 : preSum[query[0] - 1];
        return candySum > left && preCandySum < right;
    }
}
