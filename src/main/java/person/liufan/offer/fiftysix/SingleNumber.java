package person.liufan.offer.fiftysix;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftysix
 * @description: 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @date 2021/5/21
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{3, 4, 3, 3}));
    }
    public int singleNumber(int[] nums) {
        int bit = 0;
        int ans = 0;
        while (bit < 32) {
            int temp = 0;
            for (int num : nums) {
                temp += (num >>> bit & 1);
            }
            ans += (temp % 3) << bit;
            bit++;
        }
        return ans;
    }
}
