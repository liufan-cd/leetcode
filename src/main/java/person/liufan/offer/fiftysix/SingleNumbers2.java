package person.liufan.offer.fiftysix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftysix
 * @description:
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @date 2021/5/21
 */
public class SingleNumbers2 {
    public static void main(String[] args) {
        SingleNumbers2 singleNumbers2 = new SingleNumbers2();
        System.out.println(Arrays.toString(singleNumbers2.singleNumbers(new int[]{4, 1, 4, 6})));
    }
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int bit = 1;
        while ((ret & bit) != bit) {
            bit = bit << 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
