package person.liufan.primary.string;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.string
 * @description: TODO
 * @date 2021/4/13
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar(""));
    }
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int hash = c - 'a';
            if (index[hash] == 0) {
                index[hash] = i + 1;
            } else {
                index[hash] = -1;
            }
        }
        int result = s.length() + 1;
        for (int i = 0; i < index.length; i++) {
            if (index[i] > 0) {
                result = Math.min(result, index[i]);
            }
        }
        return result == s.length() + 1 ? -1 : result - 1;
    }
}
