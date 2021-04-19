package person.liufan.primary.string;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.string
 * @description: TODO
 * @date 2021/4/13
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] param = "helo".toCharArray();
        reverseString.reverseString(param);
        System.out.println(param);
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
