package person.liufan.leetcode.thousand.hundred.six.seventh;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.seventh
 * @description:
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * @date 2021/4/6
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("100", "110010"));
    }

    boolean isCarry = false;
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n > m) {
            return addBinary(b, a);
        }
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (; i <= n; i++) {
            carry(builder, a.charAt(n - i) - '0', b.charAt(m - i) - '0', isCarry);
        }
        while (i <= m || isCarry) {
            if (m - i < 0) {
                carry(builder, 0, 0, isCarry);
            } else {
                carry(builder, 0, b.charAt(m - i) - '0', isCarry);
            }
            i++;
        }
        return builder.toString();
    }

    private void carry(StringBuilder builder, int a, int b, boolean flag) {
        int temp = a + b;
        if (flag) {
            temp++;
            isCarry = false;
        }
        builder.insert(0, temp % 2);
        if ((temp / 2) != 0) {
            isCarry = true;
        }
    }
}
