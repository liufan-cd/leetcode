package person.liufan.leetcode.thousand.three.one.zero;

import person.liufan.common.ArrayUtils;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.three.one.zero
 * @description:
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/6
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
        FindMinHeightTrees findMinHeightTrees = new FindMinHeightTrees();
//        System.out.println(findMinHeightTrees.findMinHeightTrees(4, ArrayUtils.parseTwoArray("[[1,0],[1,2],[1,3]]")));
        System.out.println(findMinHeightTrees.findMinHeightTrees(6, ArrayUtils.parseTwoArray("[[0,1],[0,2],[0,3],[3,4],[4,5]]")));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0 );
            return ans;
        }

        // node-path map
        Map<Integer, Set<Integer>> nodePathMap = new HashMap<>();
        // build path
        for (int[] edge : edges) {
            buildPath(edge[0], edge[1], nodePathMap);
            buildPath(edge[1], edge[0], nodePathMap);
        }

        // get endPoints which only have edge to other
        List<Integer> endPoints = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : nodePathMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                endPoints.add(entry.getKey());
            }
        }

        while (true) {
            List<Integer> tempEndPoints = new ArrayList<>();
            // if endPoints only have two nodes check is same edge, true return answer
            if (endPoints.size() == 1) {
                return endPoints;
            } else if (endPoints.size() == 2) {
                if (nodePathMap.size() == 2) {
                    return endPoints;
                }
            }

            // remove this edge and judge contract node is endPoint, if ture add to endPoints, else do nothing
            for (int endPoint : endPoints) {
                remove(endPoint, nodePathMap, tempEndPoints);
            }

            // if endPoints only have two nodes check is same edge, true return answer

            endPoints = tempEndPoints;
        }
    }

    private void buildPath(int root, int leaf, Map<Integer, Set<Integer>> nodePathMap) {
        Set<Integer> orDefault = nodePathMap.getOrDefault(root, new HashSet<>());
        orDefault.add(leaf);
        nodePathMap.put(root, orDefault);
    }

    private void remove(int target, Map<Integer, Set<Integer>> nodePathMap, List<Integer> tempEndPoints) {
        Set<Integer> set = nodePathMap.remove(target);

        for (int integer : set) {
            Set<Integer> otherPointPath = nodePathMap.get(integer);
            otherPointPath.remove(target);

            if (otherPointPath.size() == 1) {
                tempEndPoints.add(integer);
            }
        }
    }
}
