package person.liufan.leetcode.one.zero.three.five;

import java.util.*;

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
public class MaxUncrossedLines2 {
    public static void main(String[] args) {
        MaxUncrossedLines2 maxUncrossedLines = new MaxUncrossedLines2();
        System.out.println(maxUncrossedLines.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines.maxUncrossedLines(new int[]{3,1,2,1,4,1,2,2,5,3,2,1,1,4,5,2,3,2,5,5}, new int[]{2,4,1,2,3,4,2,4,5,5,1,1,2,1,1,1,5,4,1,4,2,1,5,4,2,3,1,5,2,1}));
    }

    /**
     * 必然是正确的，但是重复太多超时了
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int m = nums1.length;
        int n = nums2.length;
        Set<Line> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(new Line(i, j));
                }
            }
        }
        this.set = set;
        return getInfo(0, nums1.length - 1, 0, nums2.length - 1);
    }
    int[] nums1;
    int[] nums2;
    Set<Line> set;
    public int getInfo(int upLeft, int upRight, int downLeft, int downRight) {
        int temp = 0;
        for (int i = upLeft; i <= upRight; i++) {
            for (int j = downLeft; j <= downRight; j++) {
                if (nums1[i] == nums2[j]) {
                    Line target = new Line(i, j);
                    if (set.contains(target)) {
                        set.remove(target);
                        temp = Math.max(temp
                                , getInfo(upLeft, i - 1, downLeft, j - 1)
                                        + getInfo(i + 1, upRight, j + 1, downRight) + 1);
                    }
                }
            }
        }
        return temp;
    }

    private class Line {
        int up, down;

        public Line(int up, int down) {
            this.up = up;
            this.down = down;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return up == line.up &&
                    down == line.down;
        }

        @Override
        public int hashCode() {
            return Objects.hash(up, down);
        }
    }
}
