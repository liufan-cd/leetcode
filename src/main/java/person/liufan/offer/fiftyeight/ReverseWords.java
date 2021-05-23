package person.liufan.offer.fiftyeight;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyeight
 * @description:
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/23
 */
public class ReverseWords {
    public static void main(String[] args) {
    }
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!"".equals(s1[i]) && !" ".equals(s1[i])) {
                builder.append(s1[i]).append(" ");
            }
        }
        if (builder.length() == 0) {
            return "";
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
