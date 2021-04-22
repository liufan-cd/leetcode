package person.liufan.middle.math;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.math
 * @description: TODO
 * @date 2021/4/21
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        int a = 2, b = 3;
        System.out.println(a + "/" + b + "=" + fractionToDecimal.fractionToDecimal(a,b));
    }

    /**
     * 想要第一个循环就发现不能用快慢指针，只能使用hash表
     * 负数要先取绝对值再算
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        int fast = numerator;
        StringBuilder builder = new StringBuilder();
        builder.append(fast / denominator);
        int temp = fast % denominator;
        if (temp == 0) {
            return builder.toString();
        }
        builder.append(".");
        int low = fast = temp * 10;
        boolean lowFlag = false;
        while (fast != 0) {
            builder.append(fast / denominator);
            fast = fast % denominator * 10;
            if (lowFlag) {
                low = low % denominator * 10;
                lowFlag = false;
            }else {
                lowFlag = true;
            }
            if (low == fast) {
                return fractionToDecimal(numerator, denominator, low);
            }
        }
        return builder.toString();
    }
    public String fractionToDecimal(int numerator, int denominator,int target) {
        StringBuilder builder = new StringBuilder();
        builder.append(numerator / denominator);
        builder.append(".");
        numerator = numerator % denominator * 10;
        while (numerator != target) {
            builder.append(numerator / denominator);
            numerator = numerator % denominator * 10;
        }
        builder.append("(");
        builder.append(numerator / denominator);
        numerator = numerator % denominator * 10;
        while (numerator != target) {
            builder.append(numerator / denominator);
            numerator = numerator % denominator * 10;
        }
        builder.append(")");
        return builder.toString();
    }
}
