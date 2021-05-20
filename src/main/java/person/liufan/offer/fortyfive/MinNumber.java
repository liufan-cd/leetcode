package person.liufan.offer.fortyfive;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fortyfive
 * @description:
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @date 2021/5/20
 */
public class MinNumber {
    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        System.out.println(minNumber.minNumber(new int[]{10,2}));
        System.out.println(minNumber.minNumber(new int[]{3,30,34,5,9}));
    }
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            strings[i++] =String.valueOf(num);
        }
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
