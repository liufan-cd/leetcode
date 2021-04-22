package person.liufan.leetcode.thousand.hundred.six.ninth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.ninth
 * @description:
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        double left = 0;
        double right = x;
        while (left < right) {
            int mid = (int) ((left + right + 1) / 2);
            double sqrt = (double) mid * (double) mid;
            if (sqrt > x) {
                right = (mid - 1);
            } else {
                left = mid;
            }
        }
        return (int) right;
    }
}
