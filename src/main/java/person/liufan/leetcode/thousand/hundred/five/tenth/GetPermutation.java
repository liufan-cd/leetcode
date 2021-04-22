package person.liufan.leetcode.thousand.hundred.five.tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.tenth
 * @description:
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class GetPermutation {
    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(1, 1));
    }
    public String getPermutation(int n, int k) {
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            sum *= i;
            list.add(i);
        }
        StringBuilder builder = new StringBuilder();
        k = k - 1;
        for (int i = n; i > 0; i--) {
            sum = sum / i;
            builder.append(list.remove(k / sum));
            k = k % sum;
        }
        return builder.toString();
    }
}
