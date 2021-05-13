package person.liufan.leetcode.one.two.six.nine;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.two.six.nine
 * @description:
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/13
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(27, 7));

    }

    /**
     * 唯一的优化问题，数组应该计算其最大值之后创建，直接创建空间占用太大
     * 考虑到行走的最远步数问题，走不到的地方或者，走不回来的地方都不应该考虑
     * 由于之前的状态并没有用，所以用两个数组就可以解决，而不是一个二维数组
     */
    public int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen, steps + 1);
        int[] ans = new int[maxColumn];
        ans[0] = 1;
        for (int i = 1; i < steps + 1; i++) {
            int[] beforeRow = ans;
            ans = new int[maxColumn];
            int edge = Math.min(Math.min(i + 2, steps - i + 1), maxColumn);
            for (int j = 0; j < edge; j++) {
                int before = j - 1 >= 0 ? beforeRow[j - 1] : 0;
                int next = j + 1 < arrLen ? beforeRow[j + 1] : 0;
                ans[j] = ((before + beforeRow[j]) % 1000000007 + next) % 1000000007;
            }
        }
        return ans[0];
    }
}
