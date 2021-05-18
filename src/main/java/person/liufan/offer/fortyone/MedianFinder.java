package person.liufan.offer.fortyone;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fortyone
 * @description:
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/18
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < 5000; i++) {
            medianFinder.addNum(-1);
            medianFinder.findMedian();
        }

    }
    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>(Comparator.comparing(integer -> -integer));
        higher = new PriorityQueue<>();
    }

    private final Queue<Integer> lower;
    private final Queue<Integer> higher;


    boolean isLower = true;
    public void addNum(int num) {
        if (isLower) {
            if (lower.isEmpty() || num <= higher.peek()) {
                lower.offer(num);
            } else {
                lower.offer(higher.poll());
                higher.offer(num);
            }
            isLower = false;
        } else {
            if (num >= lower.peek()) {
                higher.offer(num);
            } else {
                higher.offer(lower.poll());
                lower.offer(num);
            }
            isLower = true;
        }
    }

    public double findMedian() {
        return isLower ? (higher.peek() + lower.peek()) / 2d : lower.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
