package person.liufan.leetcode.one.zero.three.five;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.zero.three.five
 * @description:
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncrossed-lines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/21
 */
public class MaxUncrossedLines {
    public static void main(String[] args) {
        MaxUncrossedLines maxUncrossedLines = new MaxUncrossedLines();
        System.out.println(maxUncrossedLines.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
    }

    /**
     * 必然是正确的，但是重复太多超时了
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        return new Item(0, nums1.length - 1, 0, nums2.length - 1).getInfo();
    }

    int[] nums1;
    int[] nums2;
    private class Item {
        int upLeft,upRight,downLeft, downRight;
        public Item(int upLeft, int upRight, int downLeft, int downRight) {
            this.upLeft = upLeft;
            this.upRight = upRight;
            this.downLeft = downLeft;
            this.downRight = downRight;
        }

        public int getInfo() {
            int temp = 0;
            for (int i = upLeft; i <= upRight; i++) {
                for (int j = downLeft; j <= downRight; j++) {
                    if (nums1[i] == nums2[j]) {
                        Item left = new Item(upLeft, i - 1, downLeft, j - 1);
                        Item right = new Item(i + 1, upRight, j + 1, downRight);
                        temp = Math.max(temp, left.getInfo() + right.getInfo() + 1);
                    }
                }
            }
            return temp;
        }
    }
}
