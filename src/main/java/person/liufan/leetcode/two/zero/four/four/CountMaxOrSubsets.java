package person.liufan.leetcode.two.zero.four.four;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.two.zero.four.four
 * @description:
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 *
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 *
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/3/15
 */
public class CountMaxOrSubsets {
    public static void main(String[] args) {
        CountMaxOrSubsets countMaxOrSubsets = new CountMaxOrSubsets();
        System.out.println(countMaxOrSubsets.countMaxOrSubsets(new int[]{3,1}));
    }
    public int countMaxOrSubsets(int[] nums) {
        // key 是位数，value 是数字
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int j : nums) {
            int num = j;
            int index = 0;
            while (num != 0) {
                int remainder = num % 2;
                if (remainder == 1) {
                    List<Integer> integers = map.getOrDefault(index, new ArrayList<>());
                    integers.add(j);
                    map.put(index, integers);
                }
                num = num / 2;
                index++;
            }
        }
        
        int ans = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            ans = ans * ((int) (Math.pow(2, value.size())) - 1);
        }
        return ans;
    }
}
