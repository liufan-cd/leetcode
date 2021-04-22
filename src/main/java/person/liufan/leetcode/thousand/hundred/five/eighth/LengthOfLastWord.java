package person.liufan.leetcode.thousand.hundred.five.eighth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.eighth
 * @description:
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/2
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        //System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord(" "));
    }
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        boolean flag = false;
        int size = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ' ') {
                if (!flag) {
                    continue;
                } else {
                    break;
                }
            }
            flag = true;
            size++;
        }
        return size;
    }
}
