package person.liufan.offer.twelve;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twelve
 * @description:
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/7
 */
public class Exist {
    public static void main(String[] args) {

    }

    /**
     * 之前写过递归加剪枝
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        person.liufan.leetcode.zero.zero.seven.ninth.Exist exist = new person.liufan.leetcode.zero.zero.seven.ninth.Exist();
        return exist.exist(board, word);
    }
}
