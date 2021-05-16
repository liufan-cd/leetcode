package person.liufan.offer.seventeen;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.seventeen
 * @description:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * @date 2021/5/16
 */
public class PrintNumbers {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        printNumbers.printNumbers(5, false);
    }
    public int[] printNumbers(int n) {
        int length = 0;
        while (n != 0) {
            length = length * 10 + 9;
            n--;
        }
        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + 1;
        }
        return ans;
    }

    public void printNumbers(int n, boolean flag) {
        StringBuilder builder = new StringBuilder();
        dfs(builder, n, true);
    }

    public void dfs(StringBuilder builder, int n, boolean flag) {
        if (n == 0) {
            if (builder.length() != 0) {
                System.out.print(builder.toString() + "\t");
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!flag || i != 0) {
                builder.append(i);
                dfs(builder, n - 1, false);
                builder.deleteCharAt(builder.length() - 1);
            } else {
                dfs(builder, n - 1, true);
            }
        }
        System.out.println();
    }
}
