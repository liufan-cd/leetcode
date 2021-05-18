package person.liufan.leetcode.one.four.four.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.four.four.two
 * @description:
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/18
 */
public class CountTriplets2 {
    public static void main(String[] args) {
        CountTriplets2 countTriplets = new CountTriplets2();
        System.out.println(countTriplets.countTriplets(new int[]{1,1,1,1,1}));
    }
    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
            if (arr[i] == 0) {
                ans += i;
            }
            for (int j = 0; j < i; j++) {
                if ((arr[i] ^ arr[j]) == 0) {
                    ans += i - j - 1;
                }
            }
        }
        return ans;
    }
}
