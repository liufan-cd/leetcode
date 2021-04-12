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
public class IsScramble {
    public static void main(String[] args) {
        IsScramble isScramble = new IsScramble();
        System.out.println(isScramble.isScramble("abcdbdacbdac","bdacabcdbdac"));
    }
    public boolean isScramble(String s1, String s2) {
        if (!strEquals(s1, s2)) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        //对每个位置进行分割
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String str1 = s1.substring(i);
            String str2 = s2.substring(i);
            String preStr1 = s1.substring(0, i);
            String preStr2 = s2.substring(0, i);
            if (strEquals(str1, str2) && strEquals(preStr1, preStr2)) {
                if (isScramble(str1, str2) && isScramble(preStr1, preStr2)) {
                    return true;
                }
            }
            str1 = s1.substring(n - i);
            preStr1 = s1.substring(0, n - i);
            if (strEquals(str1, preStr2) && strEquals(preStr1, str2)) {
                if (isScramble(str1, preStr2) && isScramble(preStr1, str2)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean strEquals(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
