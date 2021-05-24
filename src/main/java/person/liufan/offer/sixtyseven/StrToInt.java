package person.liufan.offer.sixtyseven;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixtyseven
 * @description:
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *  
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/24
 */
public class StrToInt {
    public static void main(String[] args) {

    }
    public int strToInt(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.result);
    }
    /**
     * 自动机类，用于保存状态和获取处理方式
     */
    private class Automaton {
        //结果
        long result = 0;
        //符号
        int sign = 1;
        //定义状态
        String status = "start";
        /**
         * 定义所有状态
         * " "     "+"||"-"    "int"        "other"
         * start :  start       sign        number  end
         * sign :   end         end         number  end
         * number : end         end         number  end
         * end :    end         end         end     end
         */
        private Map<String, String[]> map = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "sign", "number", "end"});
            put("sign", new String[]{"end", "end", "number", "end"});
            put("number", new String[]{"end", "end", "number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        //定义方法，根据传入的c进行本类中的数据更新
        public void get(char c) {
            //根据当前状态，以及传入的字符判断现在的状态
            status = map.get(status)[getStatus(c)];
            //
            if ("number".equals(status)) {
                /**
                 * 这里为啥减'0'，因为当前字符的阿斯克码减去0的阿斯克码才是对应的int值
                 */
                result = result * 10 + c - '0';
                //判断是否越界
                result = sign == 1 ? Math.min(result, Integer.MAX_VALUE) : Math.min(result, -(long)Integer.MIN_VALUE);
            } else if ("sign".equals(status)){
                //当前位是符号位
                sign = '+' == c ? 1 : -1;
            }
        }

        //定义根据当前字符的种类迭代获取状态的方法
        public int getStatus(char c) {
            if (' ' == c) {
                return 0;
            } else if ('+' == c || '-' == c) {
                return 1;
            } else if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }
    }
}
