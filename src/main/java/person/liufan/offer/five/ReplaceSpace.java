package person.liufan.offer.five;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.five
 * @description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @date 2021/5/6
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
    }
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 32) {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
