package person.liufan.leetcode.zero.zero.four.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.zero
 * @description:
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/30
 */
public class FirstMissingPositive2 {
    public static void main(String[] args) {
        FirstMissingPositive2 positive = new FirstMissingPositive2();
        System.out.println(positive.firstMissingPositive(new int[]{1}));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0) {
                continue;
            } else {
                int value = hash[(num - 1) % n];
                if (value != 0) {
                    hash[(num - 1) % n] = Math.min(value, num);
                } else {
                    hash[(num - 1) % n] = num;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i - 1] != i) {
                return i;
            }
        }
        return n + 1;
    }
}
