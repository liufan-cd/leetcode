package person.liufan.leetcode.zero.zero.seven.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh
 * @description:
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6
 */
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }

    List<String> paths = new ArrayList<>();
    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        AutoMachine autoMachine = new AutoMachine();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            autoMachine.readOne(c,paths);
        }
        return autoMachine.endPath(paths);
    }
}
class AutoMachine{
    StringBuilder builder = new StringBuilder();
    public void readOne(char c, List<String> paths) {
        if (c == '/') {
            cateLog(paths);
        } else {
            builder.append(c);
        }
    }
    public String endPath(List<String> paths) {
        cateLog(paths);
        StringBuilder builder = new StringBuilder();
        if (paths.size() == 0) {
            return "/";
        }
        for (int i = 0; i < paths.size(); i++) {
            builder.append("/").append(paths.get(i));
        }
        return builder.toString();
    }
    public void cateLog(List<String> paths) {
        String s = builder.toString();
        if (s.equals(".")) {
        } else if (s.equals("..")) {
            if (paths.size() > 0) {
                paths.remove(paths.size() - 1);
            }
        } else {
            if (!s.equals("")) {
                paths.add(s);
            }
        }
        builder = new StringBuilder();
    }
}

