package person.liufan.leetcode.one.seven.two.three;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.seven.two.three
 * @description:
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/8
 */
public class MinimumTimeRequired {
    public static void main(String[] args) {
        MinimumTimeRequired minimumTimeRequired = new MinimumTimeRequired();
        System.out.println(minimumTimeRequired.minimumTimeRequired(new int[]{5,5,4,4,4}, 2));
    }

    /**
     * 这个方法贪心不行
     * new int[]{5,5,4,4,4}, 2
     * 这个时候贪心会先处理两个5,然后再是处理4,
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int index = jobs.length - 1 - i;
            if (index >= 0) {
                queue.offer(jobs[index]);
            }
        }
        if (queue.size() < k) {
            int ans = 0;
            while (!queue.isEmpty()) {
                ans = queue.poll();
            }
            return ans;
        }
        for (int i = jobs.length - 1 - k; i >= 0; i--) {
            int job = jobs[i];
            Integer poll = queue.poll();
            queue.offer(poll + job);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans = queue.poll();
        }
        return ans;
    }
}
