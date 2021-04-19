package person.liufan.primary.other;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.other
 * @description: TODO
 * @date 2021/4/15
 */
public class HammingWeight {
    public static void main(String[] args) {
        int param = 0XFFFFFFFD;
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(param));
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
