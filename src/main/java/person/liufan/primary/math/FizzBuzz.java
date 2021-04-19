package person.liufan.primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.math
 * @description: TODO
 * @date 2021/4/15
 */
public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }
    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        int j = 1;
        int k = 1;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (j == 3 && k == 5) {
                result.add(fizz + buzz);
                j = 0;
                k = 0;
            }else if (j == 3) {
                result.add(fizz);
                j = 0;
            } else if (k == 5) {
                result.add(buzz);
                k = 0;
            } else {
                result.add(Integer.valueOf(i).toString());
            }
            j++;
            k++;
        }
        return result;
    }
}
