package person.liufan.offer.ten;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.ten
 * @description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/6
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(7));
    }
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int i = 2;
        while (i < n) {
            second = first + second;
            first = second - first;
            second = second % 1000000007;
            i++;
        }
        return (first + second) % 1000000007;
    }
}
