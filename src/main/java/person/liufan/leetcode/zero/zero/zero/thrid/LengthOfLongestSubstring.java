package person.liufan.leetcode.zero.zero.zero.thrid;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2021/3/17
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring("dvdf"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] temp = new char[s.length()];
        int tempSize = 0;
        int resultSize = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < tempSize; j++) {
                if (chars[i] == temp[j]) {
                    i = i - tempSize + 1;
                    if (resultSize < tempSize) {
                        resultSize = tempSize;
                    }
                    tempSize = 0;
                    temp = new char[s.length()];
                    break;
                }
            }
            temp[tempSize] = chars[i];
            tempSize++;
            if (resultSize < tempSize) {
                resultSize = tempSize;
            }
        }
        return resultSize;
    }
}
