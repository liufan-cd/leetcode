package person.liufan.primary.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.other
 * @description: TODO
 * @date 2021/4/15
 */
public class Generate {
    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(15));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (i == 0) {
                    current.add(1);
                } else {
                    List<Integer> last = results.get(i - 1);
                    int pre = 0, next = 0;
                    if (j - 1 >= 0) {
                        pre = last.get(j - 1);
                    }
                    if (j != last.size()) {
                        next = last.get(j);
                    }
                    current.add(pre + next);
                }
            }
            results.add(current);
        }
        return results;
    }
}
