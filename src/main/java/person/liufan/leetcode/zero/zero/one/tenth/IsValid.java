package person.liufan.leetcode.zero.zero.one.tenth;

import java.util.ArrayList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.one.tenth
 * @description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/23
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid(")"));
    }
    public boolean isValid(String s) {
        ArrayList<Integer> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                list.add(getValue(c));
            } else {
                if (list.size() > 0) {
                    Integer remove = list.remove(list.size() - 1);
                    if (remove != getValue(c)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    public Integer getValue(char c) {
        switch (c) {
            case '(':
            case ')':
                return 1;
            case '[':
            case ']':
                return 2;
            case '{':
            case '}':
                return 3;
            default:
                return 0;
        }
    }
}
