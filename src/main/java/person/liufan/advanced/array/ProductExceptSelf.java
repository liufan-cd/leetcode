package person.liufan.advanced.array;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw8dz6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/21
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{1, 2})));
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        //正序遍历，获取当前数之前所有数的积
        int[] pre = new int[length];
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul *= nums[i];
            pre[i] = mul;
        }
        //反序遍历，获取当前数之后所有数的积
        mul = 1;
        int[] next = new int[length];
        for (int i = nums.length - 1; i >= 0; i--) {
            mul *= nums[i];
            next[i] = mul;
        }
        //叠加结果
        for (int i = 0; i < nums.length; i++) {
            int preOne = 1, nextOne = 1;
            if (i - 1 >= 0) {
                preOne = pre[i - 1];
            }
            if (i + 1 < nums.length) {
                nextOne = next[i + 1];
            }
            nums[i] = preOne * nextOne;
        }
        return nums;
    }
}
