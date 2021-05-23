package person.liufan.offer.fiftynine;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftynine
 * @description:
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @date 2021/5/23
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
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
