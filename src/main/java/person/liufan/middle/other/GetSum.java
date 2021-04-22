package person.liufan.middle.other;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.other
 * @description: TODO
 * @date 2021/4/20
 */
public class GetSum {
    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(-5, -3));
    }
    public int getSum(int a, int b) {
        int n = 0;
        boolean flag = false;
        int sum = 0;
        while (n < 32) {
            int byteA = a & 1;
            int byteB = b & 1;
            int result = byteA + byteB;
            if (flag) {
                result += 1;
            }
            switch (result) {
                case 3:
                    sum = sum | 1 << n;
                    flag = true;
                    break;
                case 2:
                    flag = true;
                    break;
                case 1:
                    sum = sum | 1 << n;
                    flag = false;
                    break;
                case 0:
                    flag = false;
                    break;
            }
            a = a >> 1;
            b = b >> 1;
            n++;
        }
        return sum;
    }
}
