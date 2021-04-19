package person.liufan.primary.math;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.math
 * @description: 统计所有小于非负整数 n 的质数的数量。
 * @date 2021/4/15
 */
public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(1));
    }

    /**
     * 欧拉筛
     * @param n 范围
     * @return 质数数量
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int[] prime = new int[n];
        int size = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                prime[size++] = i;
            }
            for (int j = 0; prime[j] * i < n; j++) {
                notPrime[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        return size;
    }
}
