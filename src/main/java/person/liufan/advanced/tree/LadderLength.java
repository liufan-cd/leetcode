package person.liufan.advanced.tree;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.advanced.tree
 * @description: TODO
 * @date 2021/4/22
 */
public class LadderLength {
    public static void main(String[] args) {

    }

    /**
     * 节点Id
     */
    Map<String,Integer> map = new HashMap<>();
    /**
     * 搜索路径
     */
    List<List<Integer>> path = new ArrayList<>();
    /**
     * 节点数量
     */
    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String str : wordList) {
            addEdge(str);
        }
        addEdge(beginWord);
        if (!map.containsKey(endWord)) {
            return 0;
        }
        addEdge(endWord);
        Queue<Integer> queue = new LinkedList<>();
        int[] dis = new int[nodeNum];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Integer beginId = map.get(beginWord);
        Integer endId = map.get(endWord);
        dis[beginId] = 0;
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            Integer currentId = queue.poll();
            if (currentId.equals(endId)) {
                return dis[currentId] / 2 + 1;
            }
            List<Integer> currentPath = path.get(currentId);
            for (Integer pathId : currentPath) {
                if (dis[pathId] == Integer.MAX_VALUE) {
                    dis[pathId] = dis[currentId] + 1;
                    queue.offer(pathId);
                }
            }
        }
        return 0;
    }

    /**
     * 建立路径
     */
    public void addEdge(String word) {
        addWord(word);
        Integer wordId = map.get(word);
        List<Integer> wordPath = path.get(wordId);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = '*';
            String str = new String(chars);
            addWord(str);
            Integer strId = map.get(str);
            wordPath.add(strId);
            path.get(strId).add(wordId);
            chars[i] = c;
        }
    }

    /**
     * 添加到节点Id中
     */
    public void addWord(String word) {
        if (!map.containsKey(word)) {
            map.put(word, nodeNum++);
            path.add(new ArrayList<>());
        }
    }
}
