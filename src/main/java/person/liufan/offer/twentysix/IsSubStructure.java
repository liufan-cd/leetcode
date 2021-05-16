package person.liufan.offer.twentysix;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.twentysix
 * @description:
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @date 2021/5/16
 */
public class IsSubStructure {
    public static void main(String[] args) {
        IsSubStructure isSubStructure = new IsSubStructure();
        TreeNode A = TreeUtils.deserialize("3,4,5,1,2");
        TreeNode B = TreeUtils.deserialize("4,1");
        System.out.println(isSubStructure.isSubStructure(A, B));
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return B != null && dfs(A, B, true);
    }

    public boolean dfs(TreeNode A, TreeNode B,boolean isRoot) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (isRoot) {
                return dfs(A.left, B.left, false) && dfs(A.right, B.right, false) || dfs(A.left, B, true) || dfs(A.right, B, true);
            } else {
                return dfs(A.left, B.left, false) && dfs(A.right, B.right, false);
            }
        } else {
            if (isRoot) {
                return dfs(A.left, B, true) || dfs(A.right, B, true);
            } else {
                return false;
            }
        }
    }
}
