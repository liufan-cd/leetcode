package person.liufan.leetcode.zero.zero.six.sixth;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.sixth
 * @description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne one = new PlusOne();
        System.out.println(Arrays.toString(one.plusOne(new int[]{9,9})));
    }
    boolean isOut = false;
    public int[] plusOne(int[] digits) {
        carry(digits, digits.length - 1, 1);
        if (isOut) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
    private void carry(int[] ints, int offset, int number) {
        int temp = ints[offset] + number;
        ints[offset] = temp % 10;
        if ((temp / 10) != 0) {
            if (offset == 0) {
                isOut = true;
            } else {
                carry(ints, offset - 1, temp / 10);
            }
        }
    }
}
