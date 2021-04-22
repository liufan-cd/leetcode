package person.liufan.leetcode.thousand.hundred.six.tenth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: org.leetcode.climbStair
 * @description: 爬楼梯计算
 * @date 2021/3/17
 */
public class ClimbStairs2 {
    public static void main(String[] args) {
        ClimbStairs2 climbStairs2 = new ClimbStairs2();
        System.out.println(climbStairs2.climbStairs(44));
    }

    /**
     * 第n层只能由第n-1层和n-2层爬上来
     */
    private int climbStairs(int n) {
        //保存n-2层方法数
        int temp1 = 1;
        //保存n-1层方法数
        int temp2 = 2;
        //保存总方法数量
        int temp3 = 0;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        for (int i = 3; i <= n; i++) {
            //当前层数方法数为上两层方法之和
            temp3 = temp1 + temp2;
            //动态爬升一层
            temp1 = temp2;
            temp2 = temp3;
        }
        return temp3;
    }
}
