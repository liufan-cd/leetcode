package person.liufan.leetcode.thousand.hundred.five.sixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.sixth
 * @description: TODO
 * @date 2021/4/2
 */
public class Merge {
    public static void main(String[] args) {
        //int[][] param = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] param = new int[][]{{1,4}};
        Merge merge = new Merge();
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
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] != start && interval[0] > end) {
                List<Integer> combine = new ArrayList<>();
                combine.add(start);
                combine.add(end);
                result.add(combine);
                start = interval[0];
            }
            end = Math.max(end, interval[1]);

        }
        List<Integer> combine = new ArrayList<>();
        combine.add(start);
        combine.add(end);
        result.add(combine);
        int[][] a = new int[result.size()][];
        int i = 0;
        for (List<Integer> integers : result) {
            a[i++] = integers.stream().mapToInt(j -> j).toArray();
        }
        return a;
    }
}
