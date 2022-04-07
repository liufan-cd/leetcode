package person.liufan.leetcode.zero.zero.zero.tenth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.tenth
 * @description: TODO
 * @date 2021/3/22
 */
public class IsMatch2 {
    public static void main(String[] args) {
        IsMatch2 isMatch2 = new IsMatch2();
        System.out.println(isMatch2.isMatch("aaa","ab*a*c*a"));
    }

    /**
     * 再加一个的条件取决于之前的的，所以可以使用动态规划来解决
     * 为什么使用动态规划？
     * 因为前一次的状态影响后一次的结果，或者说是当前一次的状态确立了之后，后一次的处理就会相对来说很容易
     * 在我做过的算法之中很明显的可以看出使用动态规划的本质上就是迭代
     * 从前一次的状态根据情况来计算出现在的状态，然后进行循环
     * 题目中要求的正则匹配，当增加一个新的字符后根据字符来进行判断
     *
     *
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        //对外层字符串循环
        for (int i = 0; i <= m; i++) {
            //内层字符串循环
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i][j - 2];
                    /**
                     * 当能够匹配的时候，说明此次比对是有效的，那么就只需要看之前的迭代状态是否是有效的
                     * 只要删除此次匹配条件是成功的（不管此次匹配成不成功都和前一次比对一样）认为这个规则被丢弃了
                     * 但是当减少一个元素比对成功，说明此次比对也成功，认为这个规则可以复用
                     * 上诉两个条件只要有一个成功就认为为真
                     */
                    if (matched(s, p, i, j - 1)) {
                        result[i][j] = result[i - 1][j] || result[i][j];
                    }
                } else {
                    if (matched(s, p, i, j)) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                }
            }
        }
        return result[m][n];
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


