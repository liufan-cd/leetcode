package person.liufan.leetcode.zero.eighth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.eighth
 * @description:
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/22
 */
public class MyAtoi2 {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("42"));
    }
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.result);
    }
}

/**
 * 自动机类，用于保存状态和获取处理方式
 */
class Automaton {
    //结果
    long result = 0;
    //符号
    int sign = 1;
    //定义状态
    String status = "start";
    /**
     * 定义所有状态
     * " "     "+"||"-"    "int"   "other"
     * start :  start   sign        number  end
     * sign :   end     end         number  end
     * number : end     end         number  end
     * end :    end     end         end     end
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

