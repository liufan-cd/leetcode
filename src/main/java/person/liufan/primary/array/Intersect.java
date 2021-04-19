package person.liufan.primary.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.array
 * @description: TODO
 * @date 2021/4/13
 */
public class Intersect {
    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        //int[] nums1 = new int[]{1,2,2,1};
        int[] nums1 = new int[]{4,9,5};
        //int[] nums2 = new int[]{2,2};
        int[] nums2 = new int[]{};
        System.out.println(Arrays.toString(intersect.intersect(nums1, nums2)));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int[] result = new int[nums2.length];
        while (j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                result[k] = nums1[i];
                i++;
                j++;
                k++;
            } else {
                j++;
            }
            if (i == nums1.length) {
                break;
            }
        }
        return Arrays.copyOf(result, k);
    }

}
