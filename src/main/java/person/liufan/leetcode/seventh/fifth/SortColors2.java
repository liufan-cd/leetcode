package person.liufan.leetcode.seventh.fifth;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.seventh.fifth
 * @description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class SortColors2 {
    public static void main(String[] args) {
        SortColors2 sortColors = new SortColors2();
        //int[] param = new int[]{2, 0, 2, 1, 1, 0};
        //int[] param = new int[]{0,1,2};
        int[] param = new int[]{2,0,1};
        //int[] param = new int[]{1,0};
        //int[] param = new int[]{2};
        sortColors.sortColors(param);
        System.out.println(Arrays.toString(param));
    }
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            int num = nums[i];
            if (num == 0) {
                nums[i] = nums[red];
                nums[red] = 0;
                red++;
            } else if (num == 2){
                nums[i] = nums[blue];
                nums[blue] = 2;
                blue--;
                i--;
            }
        }
    }
}
