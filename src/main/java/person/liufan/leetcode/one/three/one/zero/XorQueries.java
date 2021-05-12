package person.liufan.leetcode.one.three.one.zero;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.three.one.zero
 * @description:
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/12
 */
public class XorQueries {
    public static void main(String[] args) {
        XorQueries xorQueries = new XorQueries();
        int[] arr = new int[]{4,8,2,10};
        int[][] queries = new int[][]{
                {2,3},
                {1,3},
                {1,1},
                {0,3}
        };
        /*int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };*/
        System.out.println(Arrays.toString(xorQueries.xorQueries(arr, queries)));
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1];
            ans[i] = first ^ arr[queries[i][1]];
        }
        return ans;
    }
}
