package person.liufan.leetcode.thousand.hundred.six.fifth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.six.fifth
 * @description:
 * 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class IsNumber {
    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber(".e3"));
    }
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        MyAutoMachine myAutoMachine = new MyAutoMachine();
        for (int i = 0; i < chars.length; i++) {
            myAutoMachine.readOne(chars[i]);
        }
        return myAutoMachine.getResult();
    }
}
class MyAutoMachine{
    /**
     *          (+,_)       num     .       e       other
     * start    symbol      num     .       end     end
     * symbol   end         num     .       end     end
     * num      end         num     .       e       end
     * integer  end         integer end     e       end
     * .        end         integer end     e       end (标记只能一次)
     * e        sum         integer end     end     end
     * end      end         end     end     end     end
     */
    String status = "start";
    int length = 0;
    boolean isInteger = false;
    boolean preIsNum = false;
    Map<String, String[]> map = new HashMap<String, String[]>(){{
        put("start", new String[]{"symbol", "num", ".", "end", "end"});
        put("symbol", new String[]{"end", "num", ".", "end", "end"});
        put("num", new String[]{"end", "num", ".", "e", "end"});
        put("integer", new String[]{"end", "integer", "end", "e", "end"});
        put(".", new String[]{"end", "integer", "end", "e", "end"});
        put("e", new String[]{"symbol", "integer", "end", "end", "end"});
        put("end", new String[]{"end", "end", "end", "end", "end"});
    }};

    public void readOne(char c) {
        length++;
        if (status.equals("num")) {
            preIsNum = true;
        } else {
            preIsNum = false;
        }
        status = map.get(status)[getStatus(c)];
        if (status.equals("integer")) {
            isInteger = true;
        } else if (status.equals("num") && isInteger) {
            status = "integer";
        }
    }

    public boolean getResult() {
        if (status.equals("num") || status.equals("integer") || (status.equals(".") && preIsNum)) {
            return true;
        } else {
            return false;
        }

    }
    public int getStatus(char c) {
        switch (c) {
            case '+':
            case '-':
                return 0;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 1;
            case '.':
                return 2;
            case 'e':
            case 'E':
                return 3;
            default:
                return 4;
        }
    }
}
