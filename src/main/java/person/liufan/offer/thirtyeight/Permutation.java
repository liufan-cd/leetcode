package person.liufan.offer.thirtyeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtyeight
 * @description:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @date 2021/5/17
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutation("bcc")));
    }
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] builder = new char[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] isUsed = new boolean[chars.length];
        dfs(ans, builder, chars, 0, isUsed);
        return ans.toArray(new String[ans.size()]);
    }

    public void dfs(List<String> ans, char[] builder, char[] chars,int size, boolean[] isUsed) {
        if (size == chars.length) {
            ans.add(String.valueOf(builder));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i != 0 && chars[i - 1] == chars[i] && !isUsed[i - 1]) {
                continue;
            }
            if (!isUsed[i]) {
                builder[size] = chars[i];
                isUsed[i] = true;
                dfs(ans, builder, chars, size + 1, isUsed);
                isUsed[i] = false;
            }
        }
    }
}
