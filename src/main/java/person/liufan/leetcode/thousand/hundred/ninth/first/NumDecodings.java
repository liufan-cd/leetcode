package person.liufan.leetcode.thousand.hundred.ninth.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth
 * @description:
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/9
 */
public class NumDecodings {
    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("12"));
    }
    public int numDecodings(String s) {
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            //判断单个字符是否合法
            if (c != '0') {
                result[i] += result[i - 1];
            }
            if (i - 2 >= 0 && isRight(s.charAt(i - 2), c)) {
                //判断和上一个字符是否合法
                result[i] += result[i - 2];
            }
            if (c == '0' && !(i - 2 >= 0 && isRight(s.charAt(i - 2), c))) {
                return 0;
            }

        }
        return result[s.length()];
    }

    public boolean isRight(char pre, char now) {
        if (pre == '0') {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(pre).append(now);
        Integer integer = Integer.valueOf(builder.toString());
        return integer > 0 && integer <= 26;
    }
}
