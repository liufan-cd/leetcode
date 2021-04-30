package person.liufan.leetcode.thousand.one.three.seven;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.three.seven
 * @description:
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * @date 2021/4/30
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{}));
    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 + 1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer orDefault = map.getOrDefault(num, 0);
            if (orDefault == 2) {
                map.remove(num);
            } else {
                map.put(num, orDefault + 1);
            }
        }
        return map.keySet().stream().findAny().get();
    }
}
