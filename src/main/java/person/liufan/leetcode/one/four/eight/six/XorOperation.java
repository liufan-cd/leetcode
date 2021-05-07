package person.liufan.leetcode.one.four.eight.six;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.four.eight.six
 * @description:
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * @date 2021/5/7
 */
public class XorOperation {
    public static void main(String[] args) {
        XorOperation xorOperation = new XorOperation();
        //System.out.println(xorOperation.xorOperation(5, 0));
        //System.out.println(xorOperation.xorOperation(4, 3));
        System.out.println(xorOperation.xorOperation(10, 10000000));
    }
    public int xorOperation(int n, int start) {
        int i = 0;
        int ans = 0;
        while (i < n) {
            int num = start + 2 * i;
            ans ^= num;
            i++;
        }
        return ans;
    }
}
