package person.liufan.offer.fiftyseven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fiftyseven
 * @description:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/23
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        System.out.println(Arrays.deepToString(findContinuousSequence.findContinuousSequence(9)));
    }
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> combine = new LinkedList<>();
        int total = 0;
        int i = 1;
        while (i < target) {
            if (total < target) {
                total += i;
                combine.offer(i++);
            } else if (total > target) {
                int first = combine.pollFirst();
                total -= first;
            } else {
                ans.add(new ArrayList<>(combine));
                total += i;
                combine.offer(i++);
            }
        }
        return ans.stream().map(item -> item.stream().mapToInt(e -> e).toArray()).collect(Collectors.toList()).toArray(new int[][]{});
    }
}
