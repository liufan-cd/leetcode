package person.liufan.primary.other;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.other
 * @description: TODO
 * @date 2021/4/15
 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
    public int missingNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ nums[i] ^ i;
        }
        n = n ^ nums.length;
        return n;
    }
}
