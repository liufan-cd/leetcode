package person.liufan.leetcode.two.tenth;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.two.tenth
 * @description: 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25
 */
public class FindSubstring {
    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        System.out.println(findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        Set<Character> set = list.stream().map(s1 -> s1.charAt(0)).collect(Collectors.toSet());
        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        int length = words[0].length();
        int size = words.length;
        for (int i = 0; i <= s.length() - (length * size); i++) {
            if (set.contains(chars[i])) {
                boolean flag = isMatch(s.substring(i, i + (size * length)), new ArrayList<String>(list), size, length);
                if (flag) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public boolean isMatch(String s, List<String> list, int size, int length) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < size * length; i = i + length) {
            String part = new String(chars, i, length);
            if (list.contains(part)) {
                list.remove(part);
            } else {
                return false;
            }
        }
        if (list.size() == 0) {
            return true;
        }
        return false;
    }
}
