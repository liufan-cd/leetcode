package person.liufan.offer.ten;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.ten
 * @description:
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * @date 2021/5/6
 */
public class fib {
    public static void main(String[] args) {
        fib fib = new fib();
        for (int i = 0; i < 50; i++) {
            System.out.println(fib.fib(i));
        }
        System.out.println(fib.fib(48));
    }
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int i = 2;
        while (i < n) {
            second = first + second;
            first = second - first;
            second = second % 1000000007;
            i++;
        }
        return (first + second) % 1000000007;
    }
}
