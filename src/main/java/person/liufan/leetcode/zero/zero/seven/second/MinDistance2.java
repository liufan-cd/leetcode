package person.liufan.leetcode.zero.zero.seven.second;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.second
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
public class MinDistance2 {
    public static void main(String[] args) {
        MinDistance2 minDistance = new MinDistance2();
        //System.out.println(minDistance.minDistance("horse","ros"));
        System.out.println(minDistance.minDistance("123456",""));
    }

    /**
     * 不该计算对应子串，应该直接规划编辑次数
     *
     * 每次处理之后前面的字符串是相等的
     *
     * 对第一个字符进行处理，如果不相等，那么就应该有三种情况将这两字符变成相等
     * 比如a，b
     * 1.前面部分变成相等，“”和a相等，需要规划的步数，然后a插入b
     *      a   ->   a      ->  ab
     *      b   ->   ab     ->  ab
     *      a 和 “” 变成相同的步数+1
     * 或者“”插入一个a
     *      a   ->   ba     ->  ba
     *      b   ->   b      ->  ba
     *      “” 和 b 变成相同的步数+1
     * 或者a替换成b，
     *      a   ->  b   ->  b
     *      b   ->  b   ->  b
     *      “” 和 “” 的步数+1
     * 那么所有的字符都可以使用这种方法，进行规划了
     * 如果字符串相同，那么就该等于两个减一的相等次数，此时不需要额外操作
     * 不相同进行规划，判断是通过哪种方式将当前的所有字符串变成相同的字符串
     *
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
        //初始化
        for (int i = 0; i < m + 1; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            result[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    //通过修改进行
                    int modifier = result[i - 1][j - 1] + 1;
                    //通过向第一个单词插入一个字符
                    int insert1 = result[i - 1][j] + 1;
                    //通过向第二个单词插入字符
                    int insert2 = result[i][j - 1] + 1;
                    result[i][j] = Math.min(modifier, Math.min(insert1, insert2));
                }
            }
        }
        return result[m][n];
    }

}
