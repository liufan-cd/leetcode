package person.liufan.leetcode.zero.three.eight.six;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.zero.three.eight.six
 * @description:
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * @date 2022/4/18
 */
public class LexicalOrder {
    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        System.out.println(lexicalOrder.lexicalOrder(11));
    }
    public List<Integer> lexicalOrder(int n) {
        int node = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(node);
            // 优先向下
            if (node * 10 <= n) {
                node = node * 10;
            } else {
                // 右上第一个节点
                while (true) {
                    if (node % 10 != 9 && node + 1 <= n) {
                        node++;
                        break;
                    } else {
                        node = node / 10;
                    }
                }
            }
        }

        return ans;
    }
}
