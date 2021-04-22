package person.liufan.middle.searchandsort;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.searchandsort
 * @description: TODO
 * @date 2021/4/20
 */
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] param = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix.searchMatrix(param, 17));
    }

    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        this.matrix = matrix;
        this.target = target;
        return new Struct(up, down, left, right).isContain();
    }
    private class Struct{
        int up;
        int down;
        int left;
        int right;

        public Struct(int up, int down, int left, int right) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }

        public boolean isContain() {
            if (left > right || up > down) {
                return false;
            }
            if (left == right && up == down) {
                return matrix[up][left] == target;
            }
            int upMid = (up + down) >>> 1;
            int leftMid = (left + right) >>> 1;
            if (matrix[upMid][leftMid] == target) {
                return true;
            }
            Struct upLeft = new Struct(up, upMid, left, leftMid);
            Struct upRight = new Struct(up, upMid, leftMid + 1, right);
            Struct downLeft = new Struct(upMid + 1, down, left, leftMid);
            Struct downRight = new Struct(upMid + 1, down, leftMid + 1, right);
            if (matrix[upMid][leftMid] > target) {
                return upLeft.isContain()
                        || upRight.isContain()
                        || downLeft.isContain();
            } else if (matrix[upMid][right] < target){
                return downLeft.isContain() || downRight.isContain();
            } else if (matrix[down][leftMid] < target) {
                return upRight.isContain() || downRight.isContain();
            } else {
                return downRight.isContain()
                        || upRight.isContain()
                        || downLeft.isContain();
            }
        }
    }
}

