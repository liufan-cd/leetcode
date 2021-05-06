package person.liufan.offer.three.four;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.three.four
 * @description:
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/6
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int j = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int[] ints = matrix[i];
            int m = ints.length;
            for (; j < m; j++) {
                int compare = ints[j];
                if (compare == target) {
                    return true;
                }
                if (compare > target) {
                    break;
                }
            }
        }
        return false;
    }
}
