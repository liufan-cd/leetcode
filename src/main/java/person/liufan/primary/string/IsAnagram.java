package person.liufan.primary.string;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.string
 * @description: TODO
 * @date 2021/4/13
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("a", "a"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            hash[chars1[i] - 'a'] += 1;
        }
        for (int i = 0; i < chars2.length; i++) {
            hash[chars2[i] - 'a'] -= 1;
            if (hash[chars2[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
