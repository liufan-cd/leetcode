package person.liufan.leetcode.two.ninth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.two.ninth
 * @description:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25
 */
public class Divide {
    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(-1010369383,-2147483648));
    }
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        if (dividend == Integer.MIN_VALUE) {
            return flag ? divide(dividend - divisor, divisor) + 1
                    : divide(dividend + divisor, divisor) - 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return 0;
        }
        long[] init = new long[]{0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, dividend, divisor};
        while (init[0] + 1 != init[2]) {
            init = location(init);
        }
        if (init[3] == dividend) {
            return flag ? (int)init[2] : -(int) init[2];
        }
        return flag ? (int)init[0] : -(int)init[0];
    }

    /**
     * @param condition new int[]{ls(左边界),l,rs(右边界),r,dividend,divisor}
     * @return
     */
    public long[] location(long[] condition) {
        long ls = 0;
        long rs = 1;
        long l = 0;
        long r = condition[5];
        if (condition[4] - condition[1] <= r && condition[4] - condition[1] > l) {
            condition[0] = condition[0] + ls;
            condition[1] = condition[1] + l;
            condition[2] = condition[0] + rs;
            condition[3] = condition[1] + r;
            return condition;
        }
        while (true) {
            l = r;
            ls = rs;
            r = r + r;
            rs = rs + rs;
            if (condition[4] - condition[1] <= r && condition[4] - condition[1] > l) {
                break;
            }
        }
        if (condition[4] - condition[1] == r) {
            condition[0] = condition[0] + rs - 1;
            condition[1] = condition[1] + r - condition[5];
            condition[2] = condition[0] + rs;
            condition[3] = condition[1] + r;
            return condition;
        }
        condition[0] = condition[0] + ls;
        condition[1] = condition[1] + l;
        condition[2] = condition[0] + rs;
        condition[3] = condition[1] + r;
        return condition;
    }
}
