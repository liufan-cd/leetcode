package person.liufan.advanced.array;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.array
 * @description: TODO
 * @date 2021/4/21
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(
                //new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
                //new int[]{1}, 1)));
                //new int[]{1,-1}, 1)));
                //new int[]{9,11}, 2)));
                new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        //维护一个单调栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (stack.size() != 0 && nums[i] > stack.peekFirst()) {
                stack.pollFirst();
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[i] = stack.peekLast();
            //弹出元素
            int pop = nums[i];
            if (pop == stack.peekLast()) {
                stack.pollLast();
            }
            //压入元素
            int push = nums[i + k];
            while (stack.size() != 0 && push > stack.peekFirst()) {
                stack.pollFirst();
            }
            stack.push(push);
        }
        result[result.length - 1] = stack.peekLast();
        return result;
    }
}
