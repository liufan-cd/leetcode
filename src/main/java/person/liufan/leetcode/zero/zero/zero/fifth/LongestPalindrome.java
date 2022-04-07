package person.liufan.leetcode.zero.zero.zero.fifth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.fifth
 * @description: TODO
 * @date 2021/3/19
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome("aaaaa"));
    }
    public String longestPalindrome(String s) {
        String result = s;
        if (s.length() == 1) {
            return s;
        } else if (s.length() == 0) {
            return "";
        } else {
            result = "";
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i - j + 1 < 0 || i + j >= s.length()) {
                    break;
                } else if (s.charAt(i - j + 1) == s.charAt(i + j)) {
                    if ((2 * j >= result.length())) {
                        result = s.substring(i - j + 1, i + j + 1);
                    }
                } else {
                    break;
                }
            }
            for (int j = 1; j < s.length(); j++) {
                if (i - j < 0 || i + j >= s.length()) {
                    break;
                } else if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (2 * j + 1 >= result.length()) {
                        result = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return result.length() == 0 ? String.valueOf(s.charAt(0)) : result;
    }
}
