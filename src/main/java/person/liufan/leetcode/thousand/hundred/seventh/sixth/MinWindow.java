package person.liufan.leetcode.thousand.hundred.seventh.sixth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.seventh.sixth
 * @description:
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/7
 */
public class MinWindow {
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ADOBECODEBANC"));
    }
    public String minWindow(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = s.length();
        Map<String, Integer> resource = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String aChar = t.substring(i, i + 1);
            if (!resource.containsKey(aChar)) {
                resource.put(aChar, 1);
            } else {
                resource.put(aChar, resource.get(aChar) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            String aChar = s.substring(i, i + 1);
            if (t.contains(aChar)) {
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                } else {
                    map.put(aChar, map.get(aChar) + 1);
                }
                if (check(map,resource)) {
                    //TODO
                    right = i + 1;
                    while (check(map,resource)) {
                        String leftStr = s.substring(left, left + 1);
                        if (map.get(leftStr) == null) {
                            left++;
                            continue;
                        }
                        if (map.get(leftStr) == 1) {
                            map.remove(leftStr);
                        } else {
                            map.put(leftStr, map.get(leftStr) - 1);
                        }
                        left++;
                    }
                    if (minRight - minLeft > right - left) {
                        minRight = right;
                        minLeft = left;
                    }
                }
            }
        }
        return minLeft == 0 ? "" : s.substring(minLeft - 1, minRight);
    }

    public boolean check(Map<String, Integer> map, Map<String, Integer> resource) {
        if (map.size() != resource.size())
            return false;
        Iterator<Map.Entry<String,Integer>> i = resource.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String,Integer> e = i.next();
            String key = e.getKey();
            Integer value = e.getValue();
            if (value > map.get(key)) {
                return false;
            }
        }
        return true;
    }
}
