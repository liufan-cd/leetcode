package person.liufan.leetcode.zero.five.two.five;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.five.two.five
 * @description:
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * @date 2021/6/3
 */
public class FindMaxLength {
    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(new int[]{1, 0, 0, 0, 0, 1, 0, 1, 0}));
    }
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                ans = Math.max(i - map.get(sum), ans);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
