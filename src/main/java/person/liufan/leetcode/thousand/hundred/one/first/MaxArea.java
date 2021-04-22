package person.liufan.leetcode.thousand.hundred.one.first;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.one.first
 * @description: TODO
 * @date 2021/3/22
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * 超时
     * @param height
     * @return
     */
    /*public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i <= height.length - 1; i++) {
            for (int j = i + 1; j <= height.length - 1; j++) {
                result = Math.max(result, Math.min(height[i],height[j]) * (j - i));
            }
        }
        return result;
    }*/
}
