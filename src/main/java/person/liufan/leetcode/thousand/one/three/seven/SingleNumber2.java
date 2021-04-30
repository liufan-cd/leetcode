package person.liufan.leetcode.thousand.one.three.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.one.three.seven
 * @description:
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * @date 2021/4/30
 */
public class SingleNumber2 {
    public static void main(String[] args) {
        SingleNumber2 singleNumber = new SingleNumber2();
        System.out.println(singleNumber.singleNumber(new int[]{1,2,2,2}));
    }

    /**
     * 二进制计算每一位的和，和相同的数那么这一位必然是的倍数，而多出来的就是这个数的的二进制当前位置
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = 0;
            for (int num : nums) {
                temp += num >> i & 1;
            }
            ans = ans << 1;
            ans |= temp % 3;
        }
        return ans;
    }
}
