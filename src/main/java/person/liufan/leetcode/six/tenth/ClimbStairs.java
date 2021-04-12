package person.liufan.leetcode.six.tenth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: org.leetcode.climbStair
 * @description: 算法，爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17
 */
public class ClimbStairs {
    /**
     * 使用的递归计算的
     *
     * @param args
     */
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(45));
    }

    private int climbStairs(int n) {
        /**
         * 首先每次都爬一层 有一种getC(n,i-1)i为当前层数
         * 剩余1次为一个时，不能再减
         * n为偶数，n/2，n为奇数，n-1/2，java向下取整
         */
        int result = 0;
        HashMap<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for (int i = n; i >= (n + 1)/ 2; i--) {
            //i为当前元素个数，当前一次爬两阶个数为n-i
            //当前层元素个数为i个
            //种类为result种
            result += getB(i, n - i, map);
        }
        return result;
    }

    private int getB(int n, int m, Map<Integer, Map<Integer, Integer>> map) {
        //选择较小的方向计算
        return (m > n - m) ? getC(n, n - m, map) :getC(n, m, map);
    }
    private int getC(int n, int m, Map<Integer, Map<Integer,Integer>> map) {
        //获取缓存
        Map<Integer, Integer> nMap = map.get(n);
        if (nMap == null || nMap.size() == 0) {
            //初始化缓存
            nMap = new HashMap<>();
        }
        if ((m == 0) || (n == 0) || (n == m)) {
            //如果排列组合为此种，返回结果，递归终点
            nMap.put(m, 1);
            map.put(n, nMap);
            return 1;
        }
        Integer result = nMap.get(m);
        if (null == result) {
            //如果不存在缓存进行递归
            result = (getC(n - 1, m, map) + getC(n - 1, m - 1, map));
            nMap.put(m, result);
            map.put(n, nMap);
            return result;
        }else {
            //存在缓存，直接返回
            return result;
        }
    }
}
