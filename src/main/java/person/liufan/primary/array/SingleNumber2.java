package person.liufan.primary.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: TODO
 * @date 2021/4/13
 */
public class SingleNumber2 {
    public static void main(String[] args) {
        SingleNumber2 singleNumber = new SingleNumber2();
        System.out.println(singleNumber.singleNumber(new int[]{0,0,2,1,2}));
    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result = result ^ num;
        }
        return result;
    }
}
