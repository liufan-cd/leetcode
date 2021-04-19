package person.liufan.primary.dp;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.dp
 * @description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/4/15
 */
public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        //System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        //System.out.println(rob.rob(new int[]{2,7,9,3,1}));
        System.out.println(rob.rob(new int[]{9,1,3,1}));
    }
    public int rob(int[] nums) {
        int m = nums.length;
        int[] robMoney = new int[m + 3];
        robMoney[0] = robMoney[1] = robMoney[2] = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            robMoney[i + 3] = Math.max(robMoney[i], robMoney[i + 1]) + num;
        }
        return Math.max(robMoney[m + 2], robMoney[m + 1]);
    }
}
