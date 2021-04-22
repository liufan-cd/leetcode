package person.liufan.advanced.array;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwgcuv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/21
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        //System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        //System.out.println(longestConsecutive.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{1,2,0,1}));
    }
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int size = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i == 0 || nums[i] != nums[i - 1] + 1) {
                maxSize = Math.max(maxSize, size);
                size = 0;
            }
            size++;
        }
        return Math.max(maxSize, size);
    }
}
