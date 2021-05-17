package person.liufan.offer.thirty;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirty
 * @description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @date 2021/5/17
 */
public class MinStack2 {
    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(512);
        minStack2.push(-1024);
        minStack2.push(-1024);
        minStack2.push(512);
        minStack2.pop();
        System.out.println(minStack2.min());
        minStack2.pop();
        System.out.println(minStack2.min());
        minStack2.pop();
        System.out.println(minStack2.min());
    }
    /** initialize your data structure here. */
    public MinStack2() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    public void push(int val) {
        stack.push(val);
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
