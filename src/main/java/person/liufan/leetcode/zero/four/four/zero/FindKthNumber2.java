package person.liufan.leetcode.zero.four.four.zero;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.four.zero
 * @description: 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * @date 2022/3/23
 */
public class FindKthNumber2 {
    public static void main(String[] args) {
        FindKthNumber2 findKthNumber = new FindKthNumber2();
//        System.out.println(findKthNumber.findKthNumber(13, 2));
        System.out.println(findKthNumber.findKthNumber(4289384, 1922239));
//        System.out.println(findKthNumber.findKthNumber(100, 90));

    }
    public int findKthNumber(int n, int k) {
        int temp = n;
        int bit = 1;
        while ((temp /= 10) != 0) {
            bit++;
        }
        Integer[] target = new Integer[bit];
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                target[i] = j;
                int sub = getSub(target.clone(), n, bit);
                if (sub + sum >= k) {
                    sum++;
                    if (sum == k) {
                        return convertToInt(target);
                    }
                    break;
                    // default target 小于 k
                } else {
                    sum += sub;
                }
            }
        }
        return 0;
    }

    private int convertToInt(Integer[] target) {
        int ans = 0;
        for (Integer integer : target) {
            if (integer != null) {
                ans = ans * 10 + integer;
            } else {
                break;
            }
        }
        return ans;
    }

    private int getSub(Integer[] target, int n, int bit) {
        int nowBit = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == null) {
                target[i] = 0;
            } else {
                nowBit++;
            }

        }
        int convert = convertToInt(target);
        int ans = 0;
        int whileIndex = bit - nowBit;
        while (whileIndex-- != 0) {
            ans = ans * 10 + 1;
        }

        if (convert > n) {
            return ans;
        } else {
            int multi = 1;
            whileIndex = bit - nowBit;
            while (whileIndex-- != 0) {
                multi = multi * (n % 10 + 1);
                n = n / 10;
            }
            return ans + multi;
        }
    }
}
