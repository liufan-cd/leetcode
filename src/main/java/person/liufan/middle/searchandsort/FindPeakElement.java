package person.liufan.middle.searchandsort;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.searchandsort
 * @description: TODO
 * @date 2021/4/20
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1, 2, 3, 1}));
        //System.out.println(findPeakElement.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    int[] nums;
    public int findPeakElement(int[] nums) {
        this.nums = nums;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (rightUp(mid)) {
                left = mid + 1;
            } else if (leftUp(mid)) {
                right = mid - 1;
            }else {
                return mid;
            }
            if (!rightUp(left)) {
                return left;
            }
            if (!leftUp(right)) {
                return right;
            }
        }
        return 0;
    }

    public boolean rightUp(int index) {
        return index + 1 != nums.length && nums[index] < nums[index + 1];
    }
    public boolean leftUp(int index) {
        return index == 0 || nums[index - 1] > nums[index];
    }
}
