package person.liufan.middle.math;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.math
 * @description: 给定一个Excel表格中的列名称，返回其相应的列序号。
 * @date 2021/4/20
 */
public class TitleToNumber {
    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        //System.out.println(titleToNumber.titleToNumber("A"));
        //System.out.println(titleToNumber.titleToNumber("AB"));
        //System.out.println(titleToNumber.titleToNumber("ZY"));
        System.out.println(Math.pow(2, 32));
    }
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int n = chars.length;
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = chars[i] - 'A' + 1;
            int pow = (int) Math.pow(26, n - i - 1);
            result += num * pow;
        }
        return result;
    }
}
