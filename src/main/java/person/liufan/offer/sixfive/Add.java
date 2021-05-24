package person.liufan.offer.sixfive;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixfive
 * @description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @date 2021/5/23
 */
public class Add {
    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    static final int BIT_LENGTH = 31;
    public int add(int a, int b) {
        boolean carry = false;
        int ans = 0;
        for (int i = 0; i <= BIT_LENGTH; i++) {
            int aBit = a >>> i & 1;
            int bBit = b >>> i & 1;
            if (carry) {
                if (aBit == 1) {
                    if (bBit == 1) {
                        ans |= 1 << i;
                    }
                    carry = true;
                } else {
                    if (bBit == 1) {
                        carry = true;
                    } else {
                        ans |= 1 << i;
                        carry = false;
                    }
                }
            } else {
                if (aBit == 1) {
                    if (bBit == 1) {
                        carry = true;
                    } else {
                        ans |= 1 << i;
                        carry = false;
                    }
                } else {
                    if (bBit == 1) {
                        ans |= 1 << i;
                    }
                    carry = false;
                }
            }
        }
        return ans;
    }

}
