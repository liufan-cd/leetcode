package person.liufan.leetcode.zero.nine.five.four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.nine.five.four
 * @description:
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/1
 */
public class CanReorderDoubled {
    public static void main(String[] args) {
        CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);

        for (int i : arr) {
            // 偶数
            if ((i & 1) == 0) {
                if (map.containsKey(i / 2)) {
                    processMap(i / 2, map);
                } else if (map.containsKey(i * 2)) {
                    processMap(i * 2, map);
                } else {
                    Integer integer = map.getOrDefault(i, 0);
                    map.put(i, integer + 1);
                }
            } else {
                if (map.containsKey(i * 2)) {
                    processMap(i * 2, map);
                } else {
                    Integer integer = map.getOrDefault(i, 0);
                    map.put(i, integer + 1);
                }
            }
        }

        return map.size() == 0;
    }

    private void processMap(Integer i, Map<Integer, Integer> map) {
        Integer integer = map.remove(i);

        if (integer != 1) {
            map.put(i, integer - 1);
        }
    }
}
