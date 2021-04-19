package person.liufan.primary.math;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.primary.math
 * @description: TODO
 * @date 2021/4/15
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();

        int n = 0;
        while (n < 20) {
            System.out.println(isPowerOfThree.isPowerOfThree((int) Math.pow(3, n)));
            n++;
        }
    }
    public boolean isPowerOfThree(int n) {
        switch (n) {
            case 1:
            case 3:
            case 9:
            case 27:
            case 81:
            case 243:
            case 729:
            case 2187:
            case 6561:
            case 19683:
            case 59049:
            case 177147:
            case 531441:
            case 1594323:
            case 4782969:
            case 14348907:
            case 43046721:
            case 129140163:
            case 387420489:
            case 1162261467:
                return true;
            default:
                return false;
        }
    }
    /*public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }*/
    /*public boolean isPowerOfThree(int n) {
        int left = 0;
        int right = 19;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int powerOfThree = (int) Math.pow(3, mid);
            if (powerOfThree < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) Math.pow(3, left) == n;
    }*/

    /*public boolean isPowerOfThree(int n) {
        int left = 0;
        int right = 1290;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int powerOfThree = mid * mid * mid;
            if (powerOfThree < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left * left == n;
    }*/
}
