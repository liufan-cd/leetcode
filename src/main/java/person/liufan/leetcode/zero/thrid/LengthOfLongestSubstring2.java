package person.liufan.leetcode.zero.thrid;

import java.util.HashMap;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2021/3/17
 */
public class LengthOfLongestSubstring2 {
    public static void main(String[] args) {
        LengthOfLongestSubstring2 length = new LengthOfLongestSubstring2();
        System.out.println(length.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> result = new HashMap<>(s.length());
        int maxSize = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean b = result.containsKey(s.charAt(i));
            if (b) {
                int thisTemp = result.get(s.charAt(i));
                for (int j = temp - 1 < 0 ? 0 : temp - 1; j <= thisTemp; j++) {
                    result.remove(s.charAt(j), j);
                }
                temp = thisTemp;
            }
            result.put(s.charAt(i), i);
            if (maxSize < result.size()) {
                maxSize = result.size();
            }
        }
        return maxSize;
    }
}
