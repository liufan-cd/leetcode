package person.liufan.leetcode.zero.zero.seven.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.forth
 * @description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][]{
                /*{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}*/
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
    }

    int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        return searchCol(target, searchRow(target));
    }

    public int searchRow(int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
    public boolean searchCol(int target,int row) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[row][left] == target;
    }
}
