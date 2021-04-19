package person.liufan.primary.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: TODO
 * @date 2021/4/13
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{0,0,2,1,2}));
    }
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i != 0 && num == nums[i - 1]) {
                stack.pop();
            } else {
                stack.push(num);
            }
            if (stack.size() == 2) {
                stack.pop();
                break;
            }
        }
        return stack.pop();
    }

}
