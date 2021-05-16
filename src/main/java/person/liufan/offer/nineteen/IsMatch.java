package person.liufan.offer.nineteen;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.nineteen
 * @description:
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/16
 */
public class IsMatch {
    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("aa", "a.a*"));
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] ans = new boolean[m + 1][n + 1];
        ans[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    ans[i][j] = ans[i][j - 2];
                    if (matched(s, p, i, j - 1)) {
                        ans[i][j] = ans[i - 1][j] || ans[i][j];
                    }
                } else if (matched(s, p, i, j)){
                    ans[i][j] = ans[i - 1][j - 1];
                }
            }
        }
        return ans[m][n];
    }


    public boolean matched(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if ('.' == p.charAt(j - 1)) {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
