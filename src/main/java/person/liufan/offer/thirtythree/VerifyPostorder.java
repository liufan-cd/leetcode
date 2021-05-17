package person.liufan.offer.thirtythree;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.thirtythree
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @date 2021/5/17
 */
public class VerifyPostorder {
    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(new int[]{3,1}));
    }
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right, int min, int max) {
        if (left > right) {
            return true;
        }
        int root = postorder[right];
        if (root >= min && root <= max) {
            int rl = search(postorder, left, right - 1, root);
            boolean verifyLeft = verifyPostorder(postorder, left, rl - 1, min, root);
            boolean verifyRight = verifyPostorder(postorder, rl, right - 1, root, max);
            return verifyLeft && verifyRight;
        }
        return false;
    }

    public int search(int[] postorder, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (postorder[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return postorder[left] < target ? left + 1 : left;
    }
}
