package person.liufan.leetcode.third.second;

import java.util.HashMap;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.third.second
 * @description:
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @date 2021/3/25
 */
public class LongestValidParentheses2 {
    public static void main(String[] args) {
        LongestValidParentheses2 parentheses2 = new LongestValidParentheses2();
        System.out.println(parentheses2.longestValidParentheses(""));
    }
    /**
     * 动态规划处理这个问题
     * 读取每个括号，
     * 每一个有效的括号结尾必定是），所以我们用一个int数组表示对应位置的有效括号数目
     * 如果前一个是（，说明能组成一个括号
     * 如果前一个是），说明前一个可能是一个有效括号结尾，判断有效的长度，并且判断这个整体的前一个是否是（，
     * 如果是这个也是个有效的括号，所以和这个有效括号加上前一个括号的整体值，并且再加上（前面一个的有效长度，把括号拼接起来
     * 。。。。。。））是这种情况
     * 。。。。。。。（（。。。。。。。））能够匹配的上，那么此次括号长度就应该是上一个加2，
     * 。。。。。。）（（。。。。。。。））看看前面括号的有效长度，直接拼接上，前面有效长度为0就相当于就是这段括号
     * 。。。。。。（（（。。。。。。。））前面有效长度必为零
     * 上诉拼接可以直接加就行
     * 处理好越界问题
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dps = new int[s.length()];
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            //判断符号种类
            if (chars[i] == '(') {
                continue;
            }
            if (chars[i] == ')') {
                if (i == 0) {
                    continue;
                } else if (chars[i-1] == '('){
                    if (i - 2 < 0) {
                        dps[i] = 2;
                    } else {
                        dps[i] = dps[i - 2] + 2;
                    }
                } else if (chars[i - 1] == ')') {
                    if (i - dps[i - 1] - 1 < 0) {
                        continue;
                    } else if (chars[i - dps[i - 1] - 1] == '(') {
                        if (i - dps[i - 1] - 2 < 0) {
                            dps[i] = dps[i - 1] + 2;
                        } else {
                            dps[i] = dps[i - 1] + 2 + dps[i - dps[i - 1] - 2];
                        }
                    }
                }
                maxSize = Math.max(maxSize, dps[i]);
            }
        }
        return maxSize;
    }
}
