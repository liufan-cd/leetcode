package person.liufan.common;

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
}
