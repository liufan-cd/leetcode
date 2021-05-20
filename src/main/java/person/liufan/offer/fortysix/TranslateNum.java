package person.liufan.offer.fortysix;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fortysix
 * @description:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/20
 */
public class TranslateNum {
    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(12258));
    }
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] ans = new int[chars.length + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < ans.length; i++) {
            ans[i] = ans[i - 1];
            if (chars[i - 2] - '0' == 1) {
                ans[i] += ans[i - 2];
            }
            if (chars[i - 2] - '0' == 2) {
                if (chars[i - 1] - '0' < 6) {
                    ans[i] += ans[i - 2];
                }
            }
        }
        return ans[chars.length];
    }
}
