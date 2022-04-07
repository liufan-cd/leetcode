package person.liufan.leetcode.zero.three.four.two;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.three.four.two
 * @description:
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/31
 */
public class IsPowerOfFour {
    public static void main(String[] args) {
        IsPowerOfFour isPowerOfFour = new IsPowerOfFour();
        System.out.println(isPowerOfFour.isPowerOfFour(1));
        System.out.println(isPowerOfFour.isPowerOfFour(15));
    }
    public boolean isPowerOfFour(int n) {
        while (n != 0) {
            if ((n & 3) != 0) {
                return n == 1;
            }
            n = n >> 2;
        }
        return false;



        /*switch (n) {
            case 0b1:
            case 0b100:
            case 0b10000:
            case 0b1000000:
            case 0b100000000:
            case 0b10000000000:
            case 0b1000000000000:
            case 0b100000000000000:
            case 0b10000000000000000:
            case 0b1000000000000000000:
            case 0b100000000000000000000:
            case 0b10000000000000000000000:
            case 0b1000000000000000000000000:
            case 0b100000000000000000000000000:
            case 0b10000000000000000000000000000:
            case 0b1000000000000000000000000000000:
                return true;
            default:
                return false;
        }*/
    }
}
