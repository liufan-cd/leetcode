package person.liufan.leetcode.thousand.hundred.zero.seventh;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.seventh
 * @description: TODO
 * @date 2021/3/19
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-2147483648));
    }
    public int reverse(int x) {
        boolean flag = true;
        if (x == -2147483648) {
            return 0;
        }
        if (x < 0) {
            flag = false;
            x = -1 * x;
        }
        if (x == 0) {
            return 0;
        }
        int temp = x;
        if (x / 1000000000 != 0) {
            for (int i = 1000000000; i > 0; i = i / 10) {
                if (temp % 10 > (Integer.MAX_VALUE / i) % 10) {
                    return 0;
                } else if (temp % 10 == (Integer.MAX_VALUE / i) % 10) {
                    temp = temp / 10;
                } else {
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        temp = x;
        while (temp != 0) {
            builder.append(temp % 10);
            temp = temp / 10;
        }
        return flag ? Integer.valueOf(builder.toString()) : -1 * Integer.valueOf(builder.toString());
    }
}
