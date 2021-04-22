package person.liufan.middle.other;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.other
 * @description: TODO
 * @date 2021/4/20
 */
public class MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) >>> 1];
    }
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) >>> 1];
    }*/
}
