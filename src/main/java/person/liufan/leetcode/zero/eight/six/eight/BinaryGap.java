package person.liufan.leetcode.zero.eight.six.eight;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.eight.six.eight
 * @description:
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/25
 */
public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(6));
    }
    public int binaryGap(int n) {
        Integer preIndex = null;
        int index = 0;
        int ans = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                if (preIndex != null) {
                    ans = Math.max(ans, index - preIndex);
                }

                preIndex = index;
            }

            index++;
            n = n >> 1;
        }

        return ans;
    }
}
