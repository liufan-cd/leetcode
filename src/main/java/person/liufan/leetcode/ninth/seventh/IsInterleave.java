package person.liufan.leetcode.ninth.seventh;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.ninth.seventh
 * @description:
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/12
 */
public class IsInterleave {
    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        //System.out.println(isInterleave.isInterleave("a", "b", "ab"));
        //System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        //System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave.isInterleave("1", "2", "21"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][][] matched = new boolean[m + 1][n + 1][m + n + 1];
        matched[0][0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                char c3 = s3.charAt(i + j - 1);
                if (i - 1 >= 0 && c3 == s1.charAt(i - 1)) {
                    matched[i][j][i + j] = matched[i - 1][j][i + j - 1] || matched[i][j][i + j];
                }
                if (j - 1 >= 0 && c3 == s2.charAt(j - 1)) {
                    matched[i][j][i + j] = matched[i][j - 1][i + j - 1] || matched[i][j][i + j];
                }
            }
        }
        return matched[m][n][m + n];
    }
}
