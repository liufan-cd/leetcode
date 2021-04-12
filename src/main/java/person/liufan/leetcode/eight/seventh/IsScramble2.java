package person.liufan.leetcode.eight.seventh;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.eight.seventh
 * @description:
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/8
 */
public class IsScramble2 {
    public static void main(String[] args) {
        IsScramble2 isScramble = new IsScramble2();
        //System.out.println(isScramble.isScramble("eebaacbcbcadaaedceaaacadccd","eadcaacabaddaceacbceaabeccd"));
        System.out.println(isScramble.isScramble("great","rgeat"));
        //System.out.println(isScramble.isScramble("abcdbdacbdac","bdacabcdbdac"));
        //System.out.println(isScramble.isScramble("abcde","caebd"));
    }
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        boolean[][][] flag = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                for (int j = 0; j + l <= n; j++) {
                    //长度
                    for (int k = 1; k < l; k++) {
                        //截取字符串
                        boolean equals = flag[i][j][k] && flag[i + k][j + k][l - k];
                        if (equals) {
                            flag[i][j][l] = true;
                            break;
                        }
                        boolean change = flag[i][j + l - k][k] && flag[i + k][j][l - k];
                        if (change) {
                            flag[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return flag[0][0][n];
    }
}
