package person.liufan.offer.fiftyone;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyone
 * @description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @date 2021/5/21
 */
public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{-5, -6}));
    }
    public int reversePairs(int[] nums) {
        int[] location = new int[nums.length];
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, intsLength = ints.length; i < intsLength; i++) {
            int num = ints[i];
            map.put(num, i);
        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int index = map.get(num);
            max = Math.max(max, index);
            location[index]++;
            while (index++ < max) {
                ans += location[index];
            }
        }
        return ans;
    }
}
