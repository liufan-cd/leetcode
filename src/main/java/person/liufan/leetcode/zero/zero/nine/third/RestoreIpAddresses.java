package person.liufan.leetcode.zero.zero.nine.third;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.ninth.third
 * @description:
 *
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
 * @date 2021/4/9
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("0279245587303"));
    }

    List<String> result = new ArrayList<>();
    List<String> combine = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 1);
        return result;
    }

    public void dfs(String s, int index) {
        if (index == 5) {
            result.add(combine.get(0) + combine.get(1) + combine.get(2) + combine.get(3));
            return;
        }
        if (index == 4) {
            if (judge(s)) {
                combine.add(s);
                dfs(s, 5);
                combine.remove(combine.size() - 1);
            }
        }
        if (index <= 3) {
            for (int i = 1; i <= 3; i++) {
                if (s.length() - i < 4 - index) {
                    break;
                }
                String preStr = s.substring(0, i);
                if (judge(preStr)) {
                    combine.add(preStr + ".");
                    dfs(s.substring(i), index + 1);
                    combine.remove(combine.size() - 1);
                }
            }
        }
    }

    public boolean judge(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        Integer integer = Integer.valueOf(s);
        return integer >= 0 && integer <= 255;
    }
}
