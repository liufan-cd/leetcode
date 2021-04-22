package person.liufan.leetcode.thousand.hundred.zero.fifth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.zero.fifth
 * @description: TODO
 * @date 2021/3/19
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {
        LongestPalindrome2 test = new LongestPalindrome2();
        //System.out.println(test.equals("aaaa",0,3));
        System.out.println(test.longestPalindrome("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));

    }
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result = result(s, i, j, result);
                }
            }
            if (result.length() >= s.length() - i) {
                return result;
            }
        }
        return result;
    }

    public String result(String s,int a, int b,String result) {
        if (a > b) {
            if (equals(s, b, a)) {
                result = result.length() <= b + 1 - a ? s.substring(b, a + 1) : result;
            }
        } else if (a < b) {
            if (equals(s, a, b)) {
                result = result.length() <= b + 1 - a ? s.substring(a, b + 1) : result;
            }
        } else if (a == b) {
            result = result.length() <= b + 1 - a ? s.substring(a, b + 1) : result;
        }
        return result;
    }

    public boolean equals(String s,int a, int b) {
        if (a == b) {
            return true;
        } else if (a - b == 1 || b - a == 1) {
            return s.charAt(a) == s.charAt(b);
        } else {
            return s.charAt(a) == s.charAt(b) && equals(s, a + 1, b - 1);
        }
    }
}
