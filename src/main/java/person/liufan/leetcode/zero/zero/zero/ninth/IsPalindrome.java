package person.liufan.leetcode.zero.zero.zero.ninth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.ninth
 * @description:
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/22
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return equals(s, 0, s.length() - 1);
    }
    public boolean equals(String s,int a, int b) {
        if (a == b) {
            return true;
        } else if (a - b == 1 || b - a == 1) {
            return s.charAt(a) == s.charAt(b);
        } else {
            return s.charAt(a) == s.charAt(b) && equals(s, a + 1, b - 1);
        }
    }
}
