package person.liufan.middle.math;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.math
 * @description: TODO
 * @date 2021/4/20
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(3));
    }
    public int trailingZeroes(int n) {
        int size = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                int temp = i;
                while (temp % 5 == 0) {
                    temp = temp / 5;
                    size++;
                }
            }
        }
        return size;
    }
}
