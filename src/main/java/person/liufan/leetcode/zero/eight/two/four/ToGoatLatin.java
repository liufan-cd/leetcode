package person.liufan.leetcode.zero.eight.two.four;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.eight.two.four
 * @description: 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/21
 */
public class ToGoatLatin {
    public static void main(String[] args) {
        ToGoatLatin toGoatLatin = new ToGoatLatin();
        System.out.println(toGoatLatin.toGoatLatin("I speak Goat Latin"));
    }

    public String toGoatLatin(String sentence) {
        ReadMachine readMachine = new ReadMachine(sentence);
        StringBuilder ans = new StringBuilder();
        int index = 1;
        while (readMachine.hasNext()) {
            String nextWord = readMachine.getNextWord();
            if (nextWord.startsWith("a") || nextWord.startsWith("e") || nextWord.startsWith("i") || nextWord.startsWith("o") || nextWord.startsWith("u") || nextWord.startsWith("A") || nextWord.startsWith("E") || nextWord.startsWith("I") || nextWord.startsWith("O") || nextWord.startsWith("U")) {
                ans.append(nextWord);
            } else {
                ans.append(nextWord.substring(1));
                ans.append(nextWord.charAt(0));
            }
            ans.append("ma");
            int i = 0;
            while (i < index) {
                ans.append('a');
                i++;
            }
            index++;

            if (readMachine.hasNext()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    private static class ReadMachine {
        private final char[] chars;
        private int index = -1;
        private final StringBuilder builder = new StringBuilder();

        private ReadMachine(String sentence) {
            this.chars = sentence.toCharArray();
        }

        public String getNextWord() {
            loadWord();
            return builder.toString();
        }

        public boolean hasNext() {
            skip();
            return index != chars.length - 1;
        }

        private void loadWord() {
            builder.delete(0, builder.length());

            while (index + 1 < chars.length && chars[index + 1] != ' ') {
                builder.append(chars[++index]);
            }
        }

        private void skip() {
            while (index + 1 < chars.length && chars[index + 1] == ' ') {
                index++;
            }
        }
    }
}
