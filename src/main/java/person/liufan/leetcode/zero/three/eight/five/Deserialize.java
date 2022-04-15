package person.liufan.leetcode.zero.three.eight.five;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.eight.five
 * @description:
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mini-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/15
 */
public class Deserialize {
    public static void main(String[] args) {
        // [123,[456,[789]]]

    }
    public NestedInteger deserialize(String s) {
        // parse [ -> new NestedInteger
        // parse number append it
        // parse ] add number, return to parent
        // parse , add number
        Deque<NestedInteger> stack = new LinkedList<>();
        NestedInteger ans = new NestedInteger();
        stack.push(ans);
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (c == '[') {
                NestedInteger parent = stack.peek();
                NestedInteger children = new NestedInteger();
                parent.add(children);
                stack.push(children);
            } else if (c == ']') {
                addNewNumber(stack, builder);
                stack.poll();
            } else if (c == ',') {
                addNewNumber(stack, builder);
            } else {
                builder.append(c);
            }
        }

        addNewNumber(stack, builder);

        return ans.getList().get(0);
    }

    /**
     * Add a new number from builder and clean it
     */
    private void addNewNumber(Deque<NestedInteger> stack, StringBuilder builder) {
        if (builder.length() != 0) {
            stack.peek().add(new NestedInteger(Integer.parseInt(builder.toString())));
            builder.delete(0, builder.length());
        }
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
