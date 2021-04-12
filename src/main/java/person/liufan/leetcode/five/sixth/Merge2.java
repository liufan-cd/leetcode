package person.liufan.leetcode.five.sixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.five.sixth
 * @description: TODO
 * @date 2021/4/2
 */
public class Merge2 {
    public static void main(String[] args) {
        //int[][] param = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] param = new int[][]{{1,4}};
        Merge2 merge = new Merge2();
        param = merge.merge(param);
        for (int i = 0; i < param.length; i++) {
            int[] ints = param[i];
            for (int j = 0; j < ints.length; j++) {
                int a = ints[j];
                System.out.print(a + "\t");
            }
            System.out.print("\t");
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
