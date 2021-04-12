package person.liufan.leetcode.six.eighth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.six.eighth
 * @description:
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class FullJustify {
    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        int n = 20;
        List<String> list = fullJustify.fullJustify(
                //new String[]{"This", "is", "an", "example", "of", "text", "justification."}
                //new String[]{"What","must","be","acknowledgment","shall","be"}
                new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}
                , n);
        for (String s : list) {
            System.out.println(s);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(0);
        }
    }
    int size = -1;
    int maxWidth = 0;
    List<String> result = new ArrayList<>();
    List<String> row = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        for (int i = 0; i < words.length; i++) {
            readOne(words[i]);
        }
        if (row.size() != 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < row.size()-1; i++) {
                builder.append(row.get(i)).append(" ");
            }
            builder.append(row.get(row.size() - 1));
            while (size < maxWidth) {
                builder.append(" ");
                size++;
            }
            result.add(builder.toString());
        }
        return result;
    }
    public void readOne(String one) {
        int nowLength = one.length() + size + 1;
        if (nowLength > maxWidth) {
            //生成行
            int all = maxWidth - size;
            StringBuilder builder = new StringBuilder();
            if (row.size() == 1) {
                builder.append(row.get(0));
                for (int i = 0; i < all; i++) {
                    builder.append(" ");
                }
            } else {
                //计算空格
                int low = all / (row.size() - 1) + 1;
                int plus = all % (row.size() - 1);
                builder.append(row.get(0));
                for (int i = 1; i < row.size(); i++) {
                    if (i <= plus) {
                        builder.append(" ");
                    }
                    for (int j = 0; j < low; j++) {
                        builder.append(" ");
                    }
                    builder.append(row.get(i));
                }
            }
            result.add(builder.toString());
            row.clear();
            size = -1;
        }
        //缓存
        row.add(one);
        size += one.length() + 1;
    }
}
