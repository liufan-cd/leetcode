package person.liufan.leetcode.zero.zero.zero.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17
 */
public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        //定义当前层数
        for (int i = 0; i < n; i++) {
            //定义该层输出空格
            int space = n - i - 1;
            //输出空格
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            //定义该层输出*
            int star = i * 2 + 1;
            //输出*
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            //输出换行
            System.out.println();
        }
    }


    /**
     * 暴力算法，时间复杂度高了点
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        return null;
    }
}
