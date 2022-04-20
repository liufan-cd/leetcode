package person.liufan.leetcode.zero.three.eight.eight;

import java.util.LinkedList;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.eight.eight
 * @description:
 * 这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。
 * @date 2022/4/20
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        LengthLongestPath lengthLongestPath = new LengthLongestPath();
        System.out.println(lengthLongestPath.lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
    }

    /**
     * 面向对象，对于一个input，我不需要在业务中对其进行拆分，委托出去。
     */
    public int lengthLongestPath(String input) {
        AutoMachine autoMachine = new AutoMachine(input);
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int allLength = 0;
        while (autoMachine.hasNext()) {
            while (autoMachine.getLevel() <= stack.size()) {
                allLength -= stack.poll();
            }

            String nextNode = autoMachine.getNextNode();
            allLength += nextNode.length();
            stack.push(nextNode.length());
            if (nextNode.contains(".")) {
                ans = Math.max(ans, allLength + stack.size() - 1);
            }
        }

        return ans;
    }

    /**
     * 解析文件字符串类
     */
    private class AutoMachine{
        private final char[] chars;
        private StringBuilder builder = new StringBuilder();
        private int index = -1;

        public AutoMachine(String input) {
            this.chars = input.toCharArray();
            // 默认加一个初始值方便判断层级和有无后续
            builder.append('1');
        }

        public int getLevel() {
            return builder.length();
        }

        public boolean hasNext() {
            return builder.length() != 0;
        }

        public String getNextNode() {
            loadNode();
            String ans = builder.toString();
            loadFlag();
            return ans;
        }

        private void loadNode() {
            builder.delete(0, builder.length());
            while (index + 1 < chars.length && chars[index + 1] != '\n') {
                builder.append(chars[++index]);
            }
        }

        private void loadFlag() {
            builder.delete(0, builder.length());
            while (index + 1 < chars.length && (chars[index + 1] == '\n' || chars[index + 1] == '\t')) {
                builder.append(chars[++index]);
            }
        }
    }
}
