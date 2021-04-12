package person.liufan.leetcode.zero.sixth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.sixth
 * @description: TODO
 * @date 2021/3/19
 */
public class Convert {
    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.convert("123456789", 400));
    }
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        putToMap(map, 1, s.charAt(0));
        int i = 1;
        char[] chars = s.toCharArray();
        while (true) {
            for (int row = 2; row <= numRows; row++) {
                putToMap(map, row, chars[i]);
                i++;
                if (i == s.length()) {
                    return buildString(map,numRows);
                }
            }
            for (int row = numRows - 1; row >= 1; row--) {
                putToMap(map, row, chars[i]);
                i++;
                if (i == s.length()) {
                    return buildString(map,numRows);
                }
            }
        }
    }

    private void putToMap(HashMap<Integer, StringBuilder> map, int row,char c) {
        StringBuilder builder = map.get(row);
        if (builder == null) {
            builder = new StringBuilder();
            map.put(row, builder);
        }
        builder.append(c);
    }

    private String buildString(HashMap<Integer, StringBuilder> map, int row) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= row; i++) {
            StringBuilder builder = map.get(i);
            if (builder != null) {
                result.append(builder);
            }
        }
        return result.toString();
    }
}
