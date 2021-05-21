package person.liufan.offer.fiftysix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftysix
 * @description:
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @date 2021/5/21
 */
public class SingleNumbers {
    public static void main(String[] args) {

    }
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().mapToInt(e -> e).toArray();
    }
}
