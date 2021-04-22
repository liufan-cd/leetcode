package person.liufan.middle.other;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.other
 * @description:
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwvaot/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/20
 */
public class LeastInterval {
    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        //System.out.println(leastInterval.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }

    /**
     * 垃圾代码，虽然能用
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        int size = 0;
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            size++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }
        int result = 0;
        Map<Character, Integer> redis = new HashMap<>();
        while (size != 0) {
            if (queue.size() != 0) {
                //弹出当前应该执行的任务
                Character peek = queue.peek();
                if (map.get(peek) != 0) {
                    Character poll = queue.poll();
                    //执行任务
                    map.put(poll, map.get(poll) - 1);
                    size--;
                    //加入暂停执行缓存
                    redis.put(poll, n + 1);
                }
            }
            //减少等待时间
            for (Map.Entry<Character, Integer> entry : redis.entrySet()) {
                Integer value = entry.getValue();
                if (value == 0) {
                    continue;
                }
                value--;
                if (value == 0) {
                    //加入执行队列
                    queue.add(entry.getKey());
                }
                entry.setValue(value);
            }
            result++;
        }
        return result;
    }
}
