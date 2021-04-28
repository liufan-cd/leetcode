package person.liufan.leetcode.thousand.six.three.three;

import java.util.Arrays;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.six.three.three
 * @description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @date 2021/4/28
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(Integer.MAX_VALUE));
    }

    /**
     * 暴力枚举，使用了二分搜索减少了复杂度，还是耗时长
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int size = (int) Math.sqrt(c);
        int[] result = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            result[i] = i * i;
            int search = c - result[i];
            if (search(result, 0, i, search)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] result, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (result[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return result[left] == target;
    }
}
