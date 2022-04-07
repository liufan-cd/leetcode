package person.liufan.leetcode.zero.four.two.one;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.two.one
 * @description:
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/16
 */
public class FindMaximumXOR2 {
    public static void main(String[] args) {
        FindMaximumXOR2 findMaximumXOR = new FindMaximumXOR2();
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{3,10,5,25,2,8}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{0}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{2,4}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{8,10,2}));
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }

    private static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            ans = Math.max(ans, getVal(nums[i]));
        }
        return ans;
    }

    private Node root;
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
