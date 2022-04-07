package person.liufan.leetcode.zero.six.three.three;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.six.three.three
 * @description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @date 2021/4/28
 */
public class JudgeSquareSum2 {
    public static void main(String[] args) {
        JudgeSquareSum2 judgeSquareSum = new JudgeSquareSum2();
        //System.out.println(judgeSquareSum.judgeSquareSum(Integer.MAX_VALUE));
        System.out.println(judgeSquareSum.judgeSquareSum(2));
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int right = (int) Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
