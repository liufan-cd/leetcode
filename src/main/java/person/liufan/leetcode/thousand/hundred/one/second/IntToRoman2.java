package person.liufan.leetcode.thousand.hundred.one.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.one.second
 * @description:
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/22
 */
public class IntToRoman2 {
    public static void main(String[] args) {
        IntToRoman2 intToRoman = new IntToRoman2();
        System.out.println(intToRoman.intToRoman(1994));
    }
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};
        StringBuilder builder = new StringBuilder();
        for (int i = 1000; i > 0; i = i / 10) {
            int bit = num / i % 10;
            if (map.containsKey(bit * i)) {
                builder.append(map.get(bit * i));
            } else if (bit > 5) {
                bit = bit - 5;
                builder.append(map.get(5 * i));
                for (int j = 0; j < bit; j++) {
                    builder.append(map.get(i));
                }
            } else if (bit < 5) {
                for (int j = 0; j < bit; j++) {
                    builder.append(map.get(i));
                }
            }
        }
        return builder.toString();
    }
}
