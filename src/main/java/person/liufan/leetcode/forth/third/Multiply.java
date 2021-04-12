package person.liufan.leetcode.forth.third;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.forth.third
 * @description:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @date 2021/3/31
 */
public class Multiply {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String s1 = "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111";
        String s2 = "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111";
        System.out.println(s1);
        System.out.println("*");
        System.out.println(s2);
        System.out.println("=");
        System.out.println(multiply.multiply(s1,s2));
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] chars = new char[num1.length() + num2.length() + 2];
        for (int i = 0; i < chars1.length; i++) {
            int c1 = parse(chars1[chars1.length - i - 1]);
            for (int j = 0; j < chars2.length; j++) {
                int c2 = parse(chars2[chars2.length - j - 1]);
                carry(chars, i + j, c1 * c2);
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == 0 && flag) {
                continue;
            }
            flag = false;
            builder.append((char) (c + '0'));
        }
        return builder.toString();
    }

    /**
     * 进位方法
     * @param chars 结果数组
     * @param offset 偏移量，当前进位的
     * @param number 数量
     */
    private void carry(char[] chars, int offset, int number) {
        int temp = chars[offset] + number;
        chars[offset] = (char) (temp % 10);
        if ((temp / 10) != 0) {
            carry(chars, offset + 1, temp / 10);
        }
    }
    private int parse(char c) {
        return (c - '0');
    }
}
