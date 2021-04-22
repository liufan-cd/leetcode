package person.liufan.middle.other;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.other
 * @description: 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @date 2021/4/20
 */
public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        //System.out.println(evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(evalRPN.evalRPN(new String[]{"10"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-":
                    result = stack.pop();
                    result = stack.pop() - result;
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                case "/":
                    result = stack.pop();
                    result = stack.pop() / result;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
