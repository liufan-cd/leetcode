package person.liufan.leetcode.zero.zero.four.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.forth
 * @description: TODO
 * @date 2021/3/31
 */
public class IsMatch2 {
    public static void main(String[] args) {
        IsMatch2 isMatch = new IsMatch2();
        System.out.println(isMatch.isMatch("aa"
                ,"*aa"));
    }

    /**
     * 动态规划
     * 这种用个二维数组进行状态保存
     */
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int sl = s.length();
        int pl = p.length();
        boolean[][] result = new boolean[sl + 1][pl + 1];
        result[0][0] = true;
        for (int i = 1; i <= pl; ++i) {
            if (p.charAt(i - 1) == '*') {
                result[0][i] = true;
            } else {
                break;
            }
        }
        for (int pi = 1; pi <= pc.length; pi++) {
            char param = pc[pi - 1];
            for (int si = 1; si <= sc.length; si++) {
                char source = sc[si - 1];
                if (param == source || param == '?') {
                    result[si][pi] = result[si - 1][pi - 1];
                } else if (param == '*') {
                    result[si][pi] = (result[si][pi - 1] || result[si - 1][pi]);
                }
            }
        }
        return result[sl][pl];
    }
}
