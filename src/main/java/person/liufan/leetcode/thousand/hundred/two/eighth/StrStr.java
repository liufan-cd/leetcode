package person.liufan.leetcode.thousand.hundred.two.eighth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.two.eighth
 * @description:
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25
 */
public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi","issip"));
    }
    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }
        char[] resource = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i < resource.length; i++) {
            int j = 0;
            int temp = i;
            while (j < target.length && i < resource.length && resource[i] == target[j]) {
                i++;
                j++;
            }
            if (needle.length() == j) {
                return temp;
            } else {
                i = temp;
            }
        }
        return -1;
    }
}
