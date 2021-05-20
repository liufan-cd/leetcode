package person.liufan.common;

import java.util.List;

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

    public static int[][] parseTwoArray(String string, int col, int row) {
        String[] split = string.split("]");
        int[][] ans = new int[col][row];
        for (int i = 0; i < ans.length; i++) {
            int[] an = ans[i];
            char[] chars = split[i].toCharArray();
            int k = 0;
            for (int j = 0; j < an.length; j++) {
                int num = 0;
                while (k < chars.length) {
                    if (Character.isDigit(chars[k])) {
                        num = num * 10 + chars[k] - '0';
                        k++;
                    } else {
                        if (num != 0) {
                            break;
                        } else {
                            k++;
                        }
                    }
                }
                an[j] = num;
            }
        }
        return ans;
    }
}
