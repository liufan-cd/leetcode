package person.liufan.offer.sixteen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixteen
 * @description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @date 2021/5/16
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(-1, Integer.MIN_VALUE + 1));
    }
    Map<Integer, Double> map = new HashMap<>();
    public double myPow(double x, int n) {
        // 处理越界问题
        if (n == Integer.MIN_VALUE) {
            return myPow(x, n + 1) / x;
        }
        int next = n;
        double result = 1;
        // 符号
        boolean flag = (n >= 0);
        // 指数的绝对值
        n = Math.abs(n);
        while (n != 0) {
            // 用平方的方式快速乘积
            next = findNext(n);
            result *= sumPow(x, next, flag);
            n = n - next;
        }
        return result;
    }

    private int findNext(int n) {
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : (n + 1) >>> 1;
    }

    private double sumPow(double x, int n, boolean flag) {
        Double aDouble = map.get(n);
        if (flag) {
            if (aDouble == null) {
                if (n == 1) {
                    map.put(1, x);
                    return x;
                }
                // 递归调用放入缓存
                double sub = sumPow(x, findNext(n - 1), true);
                aDouble = sub * sub;
                map.put(n, aDouble);
            }
        } else {
            if (aDouble == null) {
                if (n == 1) {
                    map.put(1, 1/x);
                    return 1/x;
                }
                double sub = sumPow(x, findNext(n - 1), false);
                aDouble = sub * sub;
                map.put(n, aDouble);
            }
        }
        return aDouble;
    }
}
