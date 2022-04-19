package person.liufan.leetcode.zero.eight.two.one;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.eight.two.one
 * @description:
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/19
 */
public class ShortestToChar {
    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        System.out.println(Arrays.toString(shortestToChar.shortestToChar("e", 'e')));
    }
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int preIndex = -1;
        boolean findChar = false;
        int[] ans = new int[chars.length];
        Arrays.fill(ans, chars.length);
        // 正序遍历
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == c) {
                ans[i] = 0;
                preIndex = i;
                findChar = true;
            } else if (findChar){
                ans[i] = i - preIndex;
            }
        }
        preIndex = chars.length;
        findChar = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if (aChar == c) {
                ans[i] = 0;
                preIndex = i;
                findChar = true;
            } else if (findChar){
                ans[i] = Math.min(preIndex - i, ans[i]);
            }
        }

        return ans;
    }
}
