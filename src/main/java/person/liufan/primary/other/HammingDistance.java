package person.liufan.primary.other;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.other
 * @description: TODO
 * @date 2021/4/15
 */
public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(1, 4));
    }
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }
    public int hammingWeight(int n) {
        int hammingWeight = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if (n % 2 != 0) {
                hammingWeight++;
            }
            n = n >>> 1;
        }
        return hammingWeight;
    }
}
