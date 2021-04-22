package person.liufan.leetcode.thousand.hundred.two.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.two.second
 * @description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @date 2021/3/24
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis parenthesis = new GenerateParenthesis();
        System.out.println(parenthesis.generateParenthesis(4));
    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<StringBuilder>> map = new HashMap<>();
        StringBuilder builder0 = new StringBuilder();
        List<StringBuilder> builders0 = new ArrayList<>();
        builders0.add(builder0);
        map.put(0, builders0);
        //外层循环，即多少个括号
        for (int i = 1; i <= n; i++) {
            List<StringBuilder> builders = new ArrayList<>();
            //内层循环，计算种类数量，第n层，应该括号内0~n-1个，括号外加n-1~0个
            for (int j = 0; j < i; j++) {
                List<StringBuilder> inner = map.get(j);
                List<StringBuilder> out = map.get(i - j - 1);
                inner.stream().forEach(in -> {
                    out.stream().forEach(right -> {
                        StringBuilder builder = new StringBuilder();
                        builder.append("(")
                                .append(in)
                                .append(")")
                                .append(right);
                        builders.add(builder);
                    });
                });
            }
            map.put(i, builders);
        }
        return map.get(n).stream().map(entity -> new String(entity)).collect(Collectors.toList());
    }
}
