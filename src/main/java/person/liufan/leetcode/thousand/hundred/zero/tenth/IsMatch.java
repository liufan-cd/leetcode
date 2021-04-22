package person.liufan.leetcode.thousand.hundred.zero.tenth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.tenth
 * @description: TODO
 * @date 2021/3/22
 */
public class IsMatch {
    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("aaa","ab*a*c*a"));
    }
    public boolean isMatch(String s, String p) {
        MyAutomaton myAutomaton = new MyAutomaton(s.toCharArray(),p.toCharArray());
        for (int i = 0; i <= s.length() - 1; i++) {
            myAutomaton.assertChar();
        }
        return myAutomaton.getResult();
    }
}

/**
 * 定义一个自动机
 */
class MyAutomaton {
    char[] p;
    char[] s;
    int index = 0;
    String status = "normal";
    boolean sign = true;
    List preList;
    int temp = 0;
    /**
     *              normal      *       .
     * "normal"     normal      pre     one
     * "one"        normal      pre     one
     * "pre"        pre         pre     one
     */
    private Map<String, String[]> map = new HashMap<String, String[]>(4) {{
        put("normal", new String[]{"normal","pre","one"});
        put("one", new String[]{"normal","pre","one"});
        put("pre", new String[]{"pre","pre","one"});
    }};

    public MyAutomaton(char[] p) {
        this.p = p;
    }

    public MyAutomaton(char[] s, char[] p) {
        this.s = s;
        this.p = p;
    }

    public void assertChar() {
        for (int i = 0; i <= s.length - 1; i++) {
            char c = s[i];
            //根据当前的字符设置状态
            if (!sign || index == p.length) {
                sign = false;
                return;
            }
            status = map.get(status)[getStatus(p[index])];
            status = isPre(index) ? "pre" : status;
            if ("normal".equals(status)) {
                //当前状态是普通状态，直接判断当前的判断条件下标和传入char是否相等
                //下标加一
                sign = index == p.length ? false : (p[index++] == c);
            } else if ("one".equals(status)) {
                index++;
            } else {
                //是任意字符
                //判断当前字符是否与条件相等
                //相等则循环判断下个字符是否相等
                //不相等退出循环
                while (c == p[index]) {
                    if (i < s.length - 1) {
                        c = s[i];
                        i++;
                    } else {
                        c = s[i];
                        break;
                    }
                }
                while (index + temp + 2 != p.length) {
                    if (p[index + temp + 2] == p[index]) {
                        temp++;
                    } else {
                        break;
                    }
                }
                if (p[index] == c || p[index] == '.') {
                    return;
                } else {
                    index = index + temp + 2;
                    status = "normal";
                }
            }
        }
    }
    public int getStatus(char c) {
        if (c == '.') {
            return 2;
        } else if (c == '*') {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isPre(int index) {
        if (preList == null) {
            preList = new ArrayList<Integer>();
            if (p[0] == '*') {
                sign = false;
                return false;
            }
            for (int i = 1; i <= p.length - 1; i++) {
                if (p[i] == '*') {
                    preList.add(i - 1);
                }
            }
        }
        return preList.contains(index);
    }

    public boolean getResult() {
        if ("pre".equals(status) && ((p.length - temp) - index) % 2 == 0) {
            return sign;
        }
        return sign && index == p.length;
    }
}
