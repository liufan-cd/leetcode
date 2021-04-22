package person.liufan.middle.dp;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.dp
 * @description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/20
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        //System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        //System.out.println(lengthOfLIS.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
    public int lengthOfLIS(int[] nums) {
        //定义缓存的递增数组
        int[] temp = new int[nums.length];
        int length = 0;
        //循环数组
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = length - 1;
            //获取前一个要迁移的下标
            for (; j >= 0; j--) {
                if (num > temp[j]) {
                    break;
                }
            }
            if (j == length - 1) {
                temp[length] = num;
                length++;
            } else {
                j++;
                temp[j] = num;
            }
        }
        return length;
    }
}
