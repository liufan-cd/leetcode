package person.liufan.leetcode.one.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.forth
 * @description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @date 2021/3/22
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix pr = new LongestCommonPrefix();
        System.out.println(pr.longestCommonPrefix(new String[]{"ab","a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0 || strs[0].equals("")) {
            return "";
        }
        char c;
        //循环比较位数
        for (int i = 0; i <= strs[0].length() - 1; i++) {
            //循环字符串数组
            c = strs[0].charAt(i);
            for (int j = 0; j <= strs.length - 1; j++) {
                if (i >= strs[j].length()) {
                    return strs[0].substring(0, i);
                }
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
