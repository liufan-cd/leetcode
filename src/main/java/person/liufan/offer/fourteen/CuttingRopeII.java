package person.liufan.offer.fourteen;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fourteen
 * @description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/16
 */
public class CuttingRopeII {
    public static void main(String[] args) {

    }
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        long result = 1;
        while(n > 4){
            n -= 3;
            result *= 3;
            result %= 1000000007;
        }
        return (int)(n * result % 1000000007);
    }
}
