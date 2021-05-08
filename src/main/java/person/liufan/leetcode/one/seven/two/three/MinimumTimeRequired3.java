
package person.liufan.leetcode.one.seven.two.three;

import java.util.Arrays;
import java.util.PriorityQueue;

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
public class MinimumTimeRequired3 {
    public static void main(String[] args) {
        MinimumTimeRequired3 minimumTimeRequired = new MinimumTimeRequired3();
        System.out.println(minimumTimeRequired.minimumTimeRequired(new int[]{5,5,4,4,4}, 2));
    }

    /**
     * 二分查找，判断当前的工作量是否可以完成
     * 判读当前工作量是否可以完成要使用递归剪枝进行判断
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        // 首先获取一个逆向的排序
        Arrays.sort(jobs);
        int l = 0, r = jobs.length - 1;
        while (l < r) {
            int temp = jobs[l];
            jobs[l] = jobs[r];
            jobs[r] = temp;
            l++;
            r--;
        }
        // 二分法查找
        l = jobs[0];
        r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int currentJob = jobs[i];
        for (int j = 0; j < workloads.length; j++) {
            if (currentJob + workloads[j] <= limit) {
                workloads[j] += currentJob;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= currentJob;
            }
            // 剪枝
            // 如果当前恰好等于limit的话，我们就无须继续分配？为什么啊，因为我们优先分配的大的，所以不会最后分配不了
            // 如果前一个人没有分配，后一个人也没必要分配
            // 当前工人未分配工作，下一个工人也就没必要分配了
            // 当前工作使工作量上限了都没有成功，后续也没必要继续分配了
            if (workloads[j] == 0 || workloads[j] + currentJob == limit) {
                break;
            }
        }
        return false;
    }
}
