package person.liufan.leetcode.thousand.hundred.two.tenth;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.two.tenth
 * @description: 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25
 */
public class FindSubstring2 {
    public static void main(String[] args) {
        FindSubstring2 findSubstring = new FindSubstring2();
        System.out.println(findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            Integer integer = wordMap.get(word);
            if (integer == null) {
                integer = 1;
            } else {
                integer++;
            }
            wordMap.put(word, integer);
        }
        List<Integer> result = new ArrayList<>();
        int length = words[0].length();
        int size = words.length;
        for (int i = 0; i <= s.length() - (length * size); i++) {
            boolean flag = isMatch(s.substring(i, i + (size * length)), wordMap, size, length);
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 不单独抽出方法出来反而更慢了
     * @param subString 比对的字符串
     * @param wordMap 单词组
     * @param size 单词个数
     * @param length 单词长度
     * @return 是否是单词的一种排列组合
     */
    public boolean isMatch(String subString,HashMap<String, Integer> wordMap, int size, int length) {
        char[] chars = subString.toCharArray();
        HashMap<String, Integer> compare = new HashMap<>();
        for (int i = 0; i < size * length; i = i + length) {
            String part = new String(chars, i, length);
            if (wordMap.containsKey(part)) {
                Integer after = compare.get(part);
                Integer before = wordMap.get(part);
                if (after == null) {
                    compare.put(part, 1);
                } else {
                    if (after + 1 > before) {
                        return false;
                    }
                    compare.put(part, ++after);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
