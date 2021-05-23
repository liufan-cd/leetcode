package person.liufan.offer.sixtyone;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixtyone
 * @description:
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/23
 */
public class IsStraight {
    public static void main(String[] args) {
        IsStraight isStraight = new IsStraight();
        System.out.println(isStraight.isStraight(new int[]{0,0,1,2,6}));
    }
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                temp++;
            } else {
                if (nums[i] != nums[i + 1] - 1) {
                    temp -= nums[i + 1] - nums[i] - 1;
                }
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
        }
        return temp >= 0;
    }
}
