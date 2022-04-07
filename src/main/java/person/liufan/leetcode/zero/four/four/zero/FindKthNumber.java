package person.liufan.leetcode.zero.four.four.zero;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.four.four.zero
 * @description: 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * @date 2022/3/23
 */
public class FindKthNumber {
    public static void main(String[] args) {
        FindKthNumber findKthNumber = new FindKthNumber();
        System.out.println(findKthNumber.findKthNumber(4289384, 1922239));
        System.out.println(findKthNumber.findKthNumber(100, 90));
        System.out.println(findKthNumber.findKthNumber(13, 2));
    }
    public int findKthNumber(int n, int k) {
        Node root = new Node();
        for (int i = 1; i <= n; i++) {
            root.build(i);
        }
        Node parent = root;
        int target = 0;
        while (true) {
            for (Node sub : parent.subs) {
                if (sub == null) {
                    continue;
                }

                // 向下递归
                if (sub.count + target >= k) {
                    // 不能往下找了
                    if (sub.isEnd && sub.count == 1) {
                        return sub.originValue;
                    }

                    // 往下一层
                    if (sub.isEnd) {
                        target++;
                    }

                    if (target == k) {
                        return sub.originValue;
                    }

                    parent = sub;
                    break;
                    // default target 小于 k
                } else {
                    target += sub.count;
                }
            }
        }
    }
    private class Node{
        int count;
        Node[] subs = new Node[10];
        boolean isEnd;
        int originValue = 0;

        public void build(int num) {
            int temp = num;
            int i = 1;
            while ((temp = temp / 10) != 0) {
                i *= 10;
            }
            build(num, i, num);
        }

        private void build(int num, int i, int originValue) {
            // 如果构建完了返回
            if (i == 0) {
                return;
            }

            int index = num / i;
            subs[index] = subs[index] != null ? subs[index] : new Node();
            subs[index].build(num % i, i / 10, originValue);
            subs[index].count++;

            if (i == 1) {
                subs[index].originValue = originValue;
                subs[index].isEnd = true;
            }
        }
    }

}
