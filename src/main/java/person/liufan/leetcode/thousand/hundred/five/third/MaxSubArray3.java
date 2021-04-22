package person.liufan.leetcode.thousand.hundred.five.third;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.five.third
 * @description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @date 2021/4/1
 */
public class MaxSubArray3 {
    public static void main(String[] args) {
        MaxSubArray3 maxSubArray = new MaxSubArray3();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 分治法
     */
    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }
    class Struct{
        public int lSum,rSum,iSum, mSum;

        public Struct(int lSum, int rSum, int iSum, int mSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSum = iSum;
            this.mSum = mSum;
        }
    }
    public Struct getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Struct(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Struct lStruct = getInfo(nums, l, m);
        Struct rStruct = getInfo(nums, m + 1, r);
        return pushUp(lStruct, rStruct);
    }
    public Struct pushUp(Struct l, Struct r) {
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int iSum = l.iSum + r.iSum;
        int mSum = Math.max(l.rSum + r.lSum, Math.max(l.mSum, r.mSum));
        return new Struct(lSum, rSum, iSum, mSum);
    }
}
