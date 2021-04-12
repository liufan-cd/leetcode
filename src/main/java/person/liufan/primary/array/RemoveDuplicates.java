package person.liufan.primary.array;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary
 * @description: TODO
 * @date 2021/4/12
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            nums[offset] = nums[i];
            offset++;
        }
        return offset;
    }
}
