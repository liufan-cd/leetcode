package person.liufan.leetcode.one.zero.one.one;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.one.zero.one.one
 * @description:
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/26
 */
public class ShipWithinDays {
    public static void main(String[] args) {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        //System.out.println(shipWithinDays.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        //System.out.println(shipWithinDays.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(shipWithinDays.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    /**
     * 二分查找，在所有范围中查找weight,大于weight必能送到，小于weight不能送到
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (shipWithinDays(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean shipWithinDays(int[] weights, int D, int weight) {
        int j = 0;
        for (int i = 0; i < D; i++) {
            int sum = 0;
            while (j < weights.length && sum + weights[j] <= weight) {
                sum += weights[j];
                j++;
            }
            if (j == weights.length) {
                return true;
            }
        }
        return false;
    }
}
