package person.liufan.primary.string;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.string
 * @description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @date 2021/4/13
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        //System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome(",."));
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = s.length() - 1;
        all:
        while (left < right) {
            while (!isLetter(chars[left])) {
                left++;
                if (left >= right) {
                    break all;
                }
            }
            while (!isLetter(chars[right])) {
                right--;
                if (left >= right) {
                    break all;
                }
            }
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断这个字符是不是小写字母
     * @param c 判断字符
     * @return 是否是
     */
    private boolean isLetter(char c) {
        boolean isLowerCase = c - 'a' >= 0 && c - 'a' < 26;
        boolean isNumber = c - '0' >= 0 && c - '0' < 10;
        return isLowerCase || isNumber;
    }
}
