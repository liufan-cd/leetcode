package person.liufan.leetcode.thousand.hundred.five.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.seven
 * @description:
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @date 2021/4/2
 */
public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        //int[][] param = insert.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{1, 5});
        //int[][] param = insert.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,19}}, new int[]{0,17});
        int[][] param = insert.insert(new int[][]{{2,7},{8,8},{10,10},{12,13},{16,19}}, new int[]{9,17});
        for (int i = 0; i < param.length; i++) {
            int[] ints = param[i];
            for (int j = 0; j < ints.length; j++) {
                int a = ints[j];
                System.out.print(a + "\t");
            }
            System.out.print("\t");
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        //二分法定位
        int left = location(intervals, newInterval[0]);
        int right = location(intervals, newInterval[1]);
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        if (intervals[0][0] > newInterval[1]) {
            list.add(0, newInterval);
        } else if (intervals[intervals.length - 1][1] < newInterval[0]) {
            list.add(intervals.length, newInterval);
        } else if (intervals[left][1] < newInterval[0]) {
            newInterval[1] = Math.max(newInterval[1], intervals[right][1]);
            list.add(left + 1, newInterval);
        } else {
            newInterval = new int[]{Math.min(newInterval[0], intervals[left][0]), Math.max(newInterval[1], intervals[right][1])};
            list.set(left, newInterval);
        }
        int l = newInterval[0];
        int r = newInterval[1];
        return list.stream()
                .filter(entity -> !(entity[0] > l && entity[0] <= r))
                .collect(Collectors.toList())
                .toArray(new int[0][0]);
    }

    public int location(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (intervals[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
