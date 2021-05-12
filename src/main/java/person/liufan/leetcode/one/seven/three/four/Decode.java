package person.liufan.leetcode.one.seven.three.four;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.seven.three.four
 * @description:
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/11
 */
public class Decode {
    public static void main(String[] args) {
        Decode decode = new Decode();
        System.out.println(Arrays.toString(decode.decode(new int[]{3,1})));
        System.out.println(Arrays.toString(decode.decode(new int[]{6,5,4,6})));
    }
    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int xor = 0;
        for (int i = 0; i < n + 1; i++) {
            xor ^= i + 1;
        }
        for (int i = 1; i < encoded.length; i++) {
            encoded[i] ^= encoded[i - 1];
        }
        int first = xor;
        for (int j : encoded) {
            first ^= j;
        }
        int[] ans = new int[n + 1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = first ^ encoded[i - 1];
        }
        return ans;
    }
}
