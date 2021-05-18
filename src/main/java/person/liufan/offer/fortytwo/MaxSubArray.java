package person.liufan.offer.fortytwo;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.fortytwo
 * @description:
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * @date 2021/5/18
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private item getInfo(int[] nums, int left, int right) {
        if (left == right) {
            return new item(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = (left + right) >>> 1;
        item l = getInfo(nums, left, mid);
        item r = getInfo(nums, mid + 1, right);
        return pushUp(l, r);
    }

    private item pushUp(item l, item r) {
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int iSum = l.iSum + r.iSum;
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new item(lSum, rSum, iSum, mSum);
    }

    private class item {
        int lSum,rSum, iSum, mSum;

        public item(int lSum, int rSum, int iSum, int mSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSum = iSum;
            this.mSum = mSum;
        }
    }
}
