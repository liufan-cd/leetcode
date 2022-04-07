package person.liufan.leetcode.zero.seven.nine.six;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.seven.nine.six
 * @description:
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/7
 */
public class RotateString {
    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "cdeab"));
    }
    public boolean rotateString(String s, String goal) {
        char[] origin = s.toCharArray();
        char[] target = goal.toCharArray();
        int length = s.length();

        if (length != goal.length()) {
            return false;
        }

        for (int i = 0; i < target.length; i++) {
            if (target[i] == origin[0]) {
                for (int j = i; j - i < target.length; j++) {
                    char originChar = origin[j - i];
                    char targetChar = target[j % length];
                    if (originChar != targetChar) {
                        break;
                    }

                    if (j - i == target.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
