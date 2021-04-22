package person.liufan.leetcode.thousand.hundred.one.seventh;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.one.seventh
 * @description: TODO
 * @date 2021/3/23
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        System.out.println(combinations.letterCombinations(""));
    }
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return new ArrayList<String>();
        }
        List<char[]> list = new ArrayList<char[]>();
        list.add(new char[length]);
        //循环字符串
        for (int i = 0; i < length; i++) {
            char number = digits.charAt(i);
            char[] values = getValue(number);
            List<char[]> other = new ArrayList<char[]>();
            for (char[] chars : list) {
                for (int j = 0; j < values.length; j++) {
                    char[] copy = Arrays.copyOf(chars, length);
                    copy[i] = values[j];
                    other.add(copy);
                }
            }
            list = other;
        }
        List<String> result = list.stream().map(a -> new String(a)).collect(Collectors.toList());
        return result;
    }

    public char[] getValue(char number) {
        switch (number) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r','s'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y','z'};
            default:
                return new char[]{};
        }
    }
}
