package person.liufan.leetcode.seventh.second;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.seventh.second
 * @description:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class MinDistance {
    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        //System.out.println(minDistance.minDistance("horse","ros"));
        System.out.println(minDistance.minDistance("intention","execution"));
    }

    /**
     * 解不出来，这种动态规划，无法排除这种情况，"intention","execution"
     * 因为我假设的是最小匹配后不需要修正，剩余的只用对应替换就行，但是这种情况不能对应替换
     * 方向是对的，就是没写出来转移方程
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] result = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            char c2 = cs2[j - 1];
            for (int i = 1; i <= m; i++) {
                char c1 = cs1[i-1];
                if (c1 == c2) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return m > n ? m - result[m][n] : n - result[m][n];
    }
}
