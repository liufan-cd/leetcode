package person.liufan.leetcode.zero.five.nine.nine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.five.nine.nine
 * @description:
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/3/14
 */
public class FindRestaurant {
   public static void main(String[] args) {

   }

   public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> map = new HashMap<>();
      int ans = Integer.MAX_VALUE;
      List<String> ansString = new ArrayList<>();

      for (int i = 0; i < list1.length; i++) {
         map.put(list1[i], i);
      }

      for (int i = 0; i < list2.length; i++) {
         if (i > ans) {
            break;
         }

         Integer integer = map.get(list2[i]);

         if (integer != null) {
            int sum = integer + i;
            if (ans > sum) {
               ans = sum;
               ansString.clear();
               ansString.add(list2[i]);
            } else if (ans == sum) {
               ansString.add(list2[i]);
            }
         }
      }

      return ansString.toArray(new String[0]);
   }
}
