package person.liufan.leetcode.thousand.one.seven.two;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.seven.two
 * @description: TODO
 * @date 2022/3/25
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(Integer.MAX_VALUE));
    }
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n /= 5;
        }
        return ans;
    }
}
