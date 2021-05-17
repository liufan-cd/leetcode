package person.liufan.offer.thirty;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirty
 * @description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @date 2021/5/17
 */
public class MinStack {
    /** initialize your data structure here. */
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

    public int min() {
        return end.minVal;
    }
    private class Entry{
        Entry parent;
        int minVal = Integer.MAX_VALUE;
        int val;
    }
}
