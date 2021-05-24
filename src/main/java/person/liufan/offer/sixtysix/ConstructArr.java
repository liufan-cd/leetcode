package person.liufan.offer.sixtysix;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixtysix
 * @description:
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/24
 */
public class ConstructArr {
    public static void main(String[] args) {

    }
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        int[] pre = new int[a.length];
        int[] next = new int[a.length];
        pre[0] = 1;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = a[i - 1] * pre[i - 1];
        }
        next[next.length - 1] = 1;
        for (int i = pre.length - 2; i >= 0; i--) {
            next[i] = a[i + 1] * next[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = pre[i] * next[i];
        }
        return a;
    }
}
