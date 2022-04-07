package person.liufan.leetcode.zero.six.three.nine.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.six.three.nine.two
 * @description:
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @date 2021/5/20
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(topKFrequent.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } else {
                return (words[o1[0]]).compareTo(words[o2[0]]);
            }
        });
        Map<String, Integer> location = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            location.put(word, i);
        }
        Map<String, Long> collect = Arrays.stream(words).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Map.Entry<String, Long> word : collect.entrySet()) {
            priorityQueue.offer(new int[]{location.get(word.getKey()), Integer.parseInt(word.getValue().toString())});
        }
        List<String> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(words[priorityQueue.poll()[0]]);
        }
        return ans;
    }
}
