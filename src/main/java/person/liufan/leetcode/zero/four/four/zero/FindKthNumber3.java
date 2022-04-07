package person.liufan.leetcode.zero.four.four.zero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.four.zero
 * @description: 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * @date 2022/3/23
 */
public class FindKthNumber3 {
    public static void main(String[] args) {
        FindKthNumber3 findKthNumber = new FindKthNumber3();
        System.out.println(findKthNumber.findKthNumber(13, 5));
//        System.out.println(findKthNumber.findKthNumber(4289384, 1922239));
//        System.out.println(findKthNumber.findKthNumber(100, 90));

    }
    public int findKthNumber(int n, int k) {
        // 第一层
        // 判断特殊节点左边有多少个数，右边有多少个数
        // 计算特殊节点有多少个数
        // 如果在左边，满树找， 在右边，满树找，
        // 在中间，总数减去，左边数量和右边数量，重复过程
        int temp = n;
        // 结点数目
        int nodeSum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        while (temp != 0) {
            queue.offerLast(temp % 10);
            temp /= 10;
            nodeSum = nodeSum * 10 + 1;
        }
        int left, right = nodeSum;
        temp = n;
        int targetIndex = 0;
        int targetNodeSum = n + right;
        k = k + right;
        List<Integer> ans = new ArrayList<>(queue.size());
        while (temp != 0) {
            left = right;
            right = right / 10;
            int nodeIndex = queue.pollLast();
            int leftSum = nodeIndex * left;
            int rightSum = (9 - nodeIndex) * right;
            // 在特殊节点
            if (targetIndex + leftSum < k && targetNodeSum - rightSum >= k) {
                // 递归
                targetIndex += leftSum + 1;
                ans.add(nodeIndex);
                targetNodeSum = targetNodeSum - leftSum - rightSum;
                temp = temp / 10;
            } else if (targetIndex + leftSum >= k) {
                return getAns();
            } else {
                return getAns();
            }
        }
        return convertToInt(ans);
    }

    private int getAns() {
        return -1;
    }

    private int convertToInt(List<Integer> target) {
        int ans = 0;
        for (int integer : target) {
            ans = ans * 10 + integer;
        }
        return ans;
    }
}
