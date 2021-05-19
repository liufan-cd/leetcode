package person.liufan.offer.fortythree;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fortythree
 * @description:
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/19
 */
public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        System.out.println(countDigitOne.countDigitOne(99));
    }
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int ans = 0;
        int end = n % 10;
        n = n / 10;
        // 1、前缀减一，后缀任取
        ans += n;
        ans += countDigitOne(n - 1) * 10;
        // 2、前缀最大值，后缀只能在范围内
        if (end != 0) {
            // 意味着后缀可以取到1，结果加一
            ans += 1;
        }
        // 前缀有n个1，加上后缀的变化就应该有（end+1）* n
        ans += countOne(n) * (end + 1);
        return ans;
    }
    // 计算一个数有多少个1
    private int countOne(int n) {
        int ans = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                ans++;
            }
            n = n / 10;
        }
        return ans;
    }
}
