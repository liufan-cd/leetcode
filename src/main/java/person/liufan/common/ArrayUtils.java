package person.liufan.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.common
 * @description: 数组工具类
 * @date 2021/5/13
 */
public class ArrayUtils {
     public static  void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] ts = array[i];
            System.out.print(i+"\t>>>>>>>>");
            printArray(ts);
            System.out.println();
        }
    }

    public static void printArray(int[] array) {
        for (int t : array) {
            System.out.print(t + "\t\t");
        }
    }

    public static int[][] parseTwoArray(String string) {
        String[] split = string.split("]");
        List<List<Integer>> temp = new ArrayList<>();
        for (String s : split) {
            char[] chars = s.toCharArray();
            int k = 0;
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j < chars.length; j++) {
                Integer num = null;
                while (k < chars.length) {
                    if (Character.isDigit(chars[k])) {
                        if (num == null) {
                            num = 0;
                        }
                        num = num * 10 + chars[k] - '0';
                        k++;
                    } else {
                        if (num != null) {
                            break;
                        } else {
                            k++;
                        }
                    }
                }
                if (num != null) {
                    integers.add(num);
                }
            }
            temp.add(integers);
        }
        return temp.stream()
                .map(integers -> integers.stream()
                        .mapToInt(e -> e)
                        .toArray()
                )
                .collect(Collectors.toList())
                .toArray(new int[0][0]);
    }
}
