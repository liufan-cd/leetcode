package person.liufan.leetcode.zero.zero.four.tenth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.tenth
 * @description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * @date 2021/4/1
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(-1, Integer.MIN_VALUE + 1));
    }
    Map<Integer, Double> map = new HashMap<>();
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return myPow(x, n + 1) / x;
        }
        int next = n;
        double result = 1;
        boolean flag = (n >= 0);
        n = Math.abs(n);
        while (n != 0) {
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
