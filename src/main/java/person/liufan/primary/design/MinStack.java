package person.liufan.primary.design;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.design
 * @description: TODO
 * @date 2021/4/15
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }




    /**
     * initialize your data structure here.
     */

    Entry end = new Entry();
    public MinStack() {
    }

    public void push(int val) {
        Entry entry = new Entry();
        entry.val = val;
        entry.parent = end;
        entry.minVal = Math.min(end.minVal, val);
        end = entry;
    }

    public void pop() {
        end = end.parent;
    }

    public int top() {
        return end.val;
    }

    public int getMin() {
        return end.minVal;
    }
    private class Entry{
        Entry parent;
        int minVal = Integer.MAX_VALUE;
        int val;
    }
}
