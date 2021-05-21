package person.liufan.offer.fifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fifty
 * @description:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @date 2021/5/21
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar.firstUniqChar("abaccdeff"));
    }
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, (a, b) -> a + 1);
        }
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if (integer.equals(1)) {
                return aChar;
            }
        }
        return ' ';
    }
}
