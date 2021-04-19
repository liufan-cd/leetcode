package person.liufan.primary.array;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @date 2021/4/13
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] param = new int[]{0,1,0,23,2};
        moveZeroes.moveZeroes(param);
        System.out.println(Arrays.toString(param));
    }
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[j] = num;
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
