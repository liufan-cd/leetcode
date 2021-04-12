package person.liufan.primary.array;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: 旋转数组
 * @date 2021/4/12
 */
public class Rotate {
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] param = new int[]{1,2,3,4,5,6,7};
        //int[] param = new int[]{1,2};
        rotate.rotate(param, 3);
        System.out.println(Arrays.toString(param));
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (j < k) {
                temp[k - j - 1] = num;
                j++;
            } else {
                nums[i + k] = num;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
