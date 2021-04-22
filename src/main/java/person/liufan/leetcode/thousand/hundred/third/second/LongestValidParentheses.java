package person.liufan.leetcode.thousand.hundred.third.second;

import java.util.HashMap;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.third.second
 * @description:
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @date 2021/3/25
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses parentheses = new LongestValidParentheses();
        System.out.println(parentheses.longestValidParentheses(")()(((())))("));
    }

    /**
     * 对字符逐个读取，是左括号开始计算
     */
    public int longestValidParentheses(String s) {
        MyAutoMachine machine = new MyAutoMachine();
        MyAutoMachine machine2 = new MyAutoMachine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            machine.calculateSize(chars[i]);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[i] == '(') {
                machine2.calculateSize(')');
            } else {
                machine2.calculateSize('(');
            }
        }
        return Math.max(machine.getMaxSize(), machine2.getMaxSize());
    }
}

/**
 *          "("     ")"
 *
 * ready    sum     ready
 *
 * sum      sum     judge
 *
 * judge    ready   sum
 *
 * 没必要写自动机，流程太简单了
 */
class MyAutoMachine{
    String status = "ready";
    int maxSize = 0;
    int left = 0;
    int right = 0;
    private HashMap<String, String[]> map = new HashMap<String, String[]>() {{
        put("ready", new String[]{"sum", "ready"});
        put("sum", new String[]{"sum", "judge"});
        put("judge", new String[]{"ready", "sum"});
    }};

    public void calculateSize(char c) {
        status = map.get(status)[getStatus(c)];
        if ("ready".equals(status)) {
            return;
        }
        if ("sum".equals(status)) {
            left++;
        }
        if ("judge".equals(status)) {
            if (left > right + 1) {
                status = "sum";
                right++;
            } else if (left == right + 1) {
                status = "sum";
                right++;
                maxSize = Math.max(maxSize, left + right);
            } else {
                status = "ready";
                maxSize = Math.max(maxSize, left + right);
                right = 0;
                left = 0;
            }
        }
    }

    public int getMaxSize() {
        if (left == right) {
            return Math.max(maxSize, left + right);
        } else {
            return maxSize;
        }
    }

    public int getStatus(char c) {
        switch (c) {
            case '(':
                return 0;
            case ')':
                return 1;
        }
        return -1;
    }
}