package person.liufan.leetcode.zero.seven.two.zero;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.seven.two.zero
 * @description:
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/3/17
 */
public class LongestWord {
    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
    public String longestWord(String[] words) {
        Node root = new Node();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            int maxDeep = root.getMaxDeep(word.toCharArray(), 0);

            if (maxDeep == word.length() - 1) {
                root.build(word.toCharArray(), 0);
            }
        }
        String ans = "";
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (root.getMaxDeep(word.toCharArray(), 0) != word.length()) {
                continue;
            }

            if (ans.length() > word.length()) {
                break;
            }

            if (ans.length() < word.length() || ans.compareTo(word)>0) {
                ans = word;
            }
        }

        return ans;
    }

    private static class Node {
        private final Node[] nodes = new Node[26];

        public void build(char[] chars, int i) {
            // 如果构建完了返回
            if (i == chars.length) {
                return;
            }

            int index = chars[i] - 'a';
            nodes[index] = nodes[index] != null ? nodes[index] : new Node();
            nodes[index].build(chars, i + 1);
        }


        // 获取深度
        public int getMaxDeep(char[] chars, int i) {
            // 如果比较完了，所有都能找到
            if (i == chars.length) {
                return i;
            }

            int index = chars[i] - 'a';

            return nodes[index] != null ? nodes[index].getMaxDeep(chars, i + 1) : i;
        }
    }
}
