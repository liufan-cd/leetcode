package person.liufan.leetcode.one.one.nine.zero;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.one.nine.zero
 * @description:
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/26
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        ReverseParentheses reverseParentheses = new ReverseParentheses();
        System.out.println(reverseParentheses.reverseParentheses("(ab)(ac)"));
        System.out.println(reverseParentheses.reverseParentheses("(ab()ac)"));
        System.out.println(reverseParentheses.reverseParentheses("(ed(et(oc))el)"));
    }

    public String reverseParentheses(String s) {
        boolean isReverse = false;
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int[] match = new int[s.length()];
        Arrays.fill(match, -1);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                isReverse = !isReverse;
                stack.push(i);
            } else if (aChar == ')') {
                int poll = stack.poll();
                match[poll] = i;
                match[i] = poll;
            }
        }
        return reverseParentheses(s, match, 0, s.length() - 1, false);
    }

    public String reverseParentheses(String s, int[] match, int left, int right, boolean isReverse) {
        for (int i = left; i <= right; i++) {
            if (match[i] != -1) {
                if (isReverse) {
                    return reverseParentheses(s, match, match[i] + 1, right, true) +
                            reverseParentheses(s, match, i + 1, match[i] - 1, false)
                            + reverseParentheses(s, match, left, i - 1, true);
                } else {
                    return reverseParentheses(s, match, left, i - 1, false) +
                            reverseParentheses(s, match, i + 1, match[i] - 1, true)
                            + reverseParentheses(s, match, match[i] + 1, right, false);
                }
            }
        }
        if (left > right) {
            return "";
        }
        if (isReverse) {
            return new StringBuilder(s.substring(left, right + 1)).reverse().toString();
        } else {
            return s.substring(left, right + 1);
        }
    }
    /*public String reverseParentheses(String s) {
        return reverseParentheses(s, false);
    }

    public String reverseParentheses(String s, boolean isReverse) {
        int left = s.indexOf('(');
        if (left == -1) {
            if (isReverse) {
                return new StringBuilder(s).reverse().toString();
            } else {
                return s;
            }
        }
        int right = s.indexOf(')', left);
        String preStr = s.substring(0, left);
        String midStr = s.substring(left + 1, right);
        String endStr = s.substring(right+1);
        if (isReverse) {
            return reverseParentheses(endStr, true) + reverseParentheses(midStr, false) + reverseParentheses(preStr, true);
        } else {
            return reverseParentheses(preStr, false) + reverseParentheses(midStr, true) + reverseParentheses(endStr, false);
        }
    }*/

    /*public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        Deque<Character> preQueue = new LinkedList<>();
        Deque<Character> endQueue = new LinkedList<>();
        boolean isReverse = false;
        while (true) {
            while (left <= right) {
                if (chars[left] != '(' && chars[left] != ')') {
                    if (isReverse) {
                        endQueue.offerFirst(chars[left++]);
                    } else {
                        preQueue.offer(chars[left++]);
                    }
                } else {
                    left++;
                    break;
                }
            }
            while (left <= right) {
                if (chars[right] != '(' && chars[right] != ')') {
                    if (isReverse) {
                        preQueue.offer(chars[right--]);
                    } else {
                        endQueue.offerFirst(chars[right--]);
                    }
                } else {
                    right--;
                    break;
                }
            }
            isReverse = !isReverse;
            if (left > right) {
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!preQueue.isEmpty()) {
            builder.append(preQueue.pollFirst());
        }
        while (!endQueue.isEmpty()) {
            builder.append(endQueue.pollFirst());
        }
        return builder.toString();
    }*/







    /*public String reverseParentheses(String s) {
        if (s.endsWith(")")) {
            return reverseParentheses(s, true).toString();
        } else {
            int lastIndexOf = s.lastIndexOf(")");
            StringBuilder builder = reverseParentheses(s.substring(0, lastIndexOf + 1), true);
            builder.append(s.substring(lastIndexOf + 1));
            return builder.toString();
        }
    }
    public StringBuilder reverseParentheses(String s, boolean flag) {
        String[] split = s.split("[()]");
        Deque<String> preQueue = new LinkedList<>();
        Deque<String> endQueue = new LinkedList<>();
        char[] chars = s.toCharArray();
        int index = 1;
        boolean isReverse = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                isReverse = !isReverse;
                if (!isReverse) {
                    preQueue.offer(split[index++]);
                } else {
                    endQueue.offerFirst(new StringBuilder(split[index++]).reverse().toString());
                }
            } else if (c == ')') {
                if (i == chars.length - 1) {
                    break;
                }
                isReverse = !isReverse;
                if (!isReverse) {
                    endQueue.offerFirst(split[index++]);
                } else {
                    preQueue.offerFirst(new StringBuilder(split[index++]).reverse().toString());
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(split[0]);
        while (!preQueue.isEmpty()) {
            builder.append(preQueue.pollFirst());
        }
        while (!endQueue.isEmpty()) {
            builder.append(endQueue.pollFirst());
        }
        return builder;
    }*/
}
