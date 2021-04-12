package person.liufan.primary.array;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary
 * @description: TODO
 * @date 2021/4/12
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7,6,5,4}));
    }
    public int maxProfit(int[] prices) {
        int sum = 0;
        Integer pre = null;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (pre == null) {
                pre = price;
            } else {
                if (price > pre) {
                    sum += price - pre;
                }
                pre = price;
            }
        }
        return sum;
    }
}
