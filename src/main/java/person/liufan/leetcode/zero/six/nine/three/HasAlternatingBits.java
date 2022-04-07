package person.liufan.leetcode.zero.six.nine.three;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.six.nine.three
 * @description:
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * @date 2022/3/28
 */
public class HasAlternatingBits {
    public static void main(String[] args) {
        HasAlternatingBits hasAlternatingBits = new HasAlternatingBits();
        System.out.println(hasAlternatingBits.hasAlternatingBits(21));
    }
    /*public boolean hasAlternatingBits(int n) {
        // flag = false 0, flag = true 1
        boolean flag = !((n & 1) == 1);
        boolean temp;

        while (n != 0) {
            temp = (n & 1) == 1;

            if (flag == temp) {
                return false;
            }

            flag = temp;
            n = n >> 1;
        }

        return true;
    }*/
    /*public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            // 最后两位相同
            if (((n ^ (n >> 1)) & 1) != 1) {
                return false;
            }
            n = n >> 1;
        }

        return true;
    }*/

    public boolean hasAlternatingBits(int n) {
        // 错位异或
        int temp = n ^ (n >> 1);
        // 如果相邻两位不相同，所有位都应该是1
        // 正整数不会越界
        return (temp & temp + 1) == 0;
    }
}
