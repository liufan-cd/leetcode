package person.liufan.leetcode.one.seven.zero.seven;

import person.liufan.common.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.seven.zero.seven
 * @description:
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 *
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 *
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/23
 */
public class MaximizeXor {
    public static void main(String[] args) {
        MaximizeXor maximizeXor = new MaximizeXor();
        System.out.println(Arrays.toString(maximizeXor.maximizeXor(new int[]{0,1,2,3,4}, ArrayUtils.parseTwoArray("[3,1],[1,3],[5,6]"))));
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        root = new Node();
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            queue.offer(new int[]{query[0], query[1], i});
        }
        for (int num : nums) {
            while (queue.peek() != null && num > queue.peek()[1]) {
                int[] query = queue.poll();
                int index = query[2];
                if (query[1] < nums[0]) {
                    ans[index] = -1;
                } else {
                    ans[index] = getVal(query[0]);
                }
            }
            add(num);
            while (queue.peek() != null && num == queue.peek()[1]) {
                int[] query = queue.poll();
                int index = query[2];
                if (query[1] < nums[0]) {
                    ans[index] = -1;
                } else {
                    ans[index] = getVal(query[0]);
                }
            }
            if (queue.isEmpty()) {
                break;
            }
        }
        while (queue.peek() != null) {
            int[] query = queue.poll();
            int index = query[2];
            ans[index] = getVal(query[0]);
        }
        return ans;
    }

    private Node root;
    private static final int HIGH_BIT = 31;
    public void add(int num) {
        Node p = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int temp = num >> i & 1;
            if (temp == 0) {
                if (p.nodes[0] == null) {
                    p.nodes[0] = new Node();
                }
                p = p.nodes[0];
            } else {
                if (p.nodes[1] == null) {
                    p.nodes[1] = new Node();
                }
                p = p.nodes[1];
            }
        }
    }

    private int getVal(int num) {
        Node p = root;
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int temp = num >> i & 1;
            ans = ans << 1;
            if (temp == 0) {
                if (p.nodes[1] == null) {
                    ans += 0;
                    p = p.nodes[0];
                } else {
                    ans += 1;
                    p = p.nodes[1];
                }
            } else {
                if (p.nodes[0] == null) {
                    ans += 0;
                    p = p.nodes[1];
                } else {
                    ans += 1;
                    p = p.nodes[0];
                }
            }
        }
        return ans;
    }

    class Node {
        Node[] nodes = new Node[2];
    }
}
