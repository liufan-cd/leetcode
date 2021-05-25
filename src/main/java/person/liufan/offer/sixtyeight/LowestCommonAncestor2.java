package person.liufan.offer.sixtyeight;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.sixtyeight
 * @description:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/24
 */
public class LowestCommonAncestor2 {
    public static void main(String[] args) {
        LowestCommonAncestor2 lowestCommonAncestor2 = new LowestCommonAncestor2();
        TreeNode param = TreeUtils.deserialize("3,5,1,6,2,0,8,null,null,7,4").printTree();
        lowestCommonAncestor2.lowestCommonAncestor(param,param.left.left,param.left.right).printTree();
    }
    private TreeNode ans;

    public LowestCommonAncestor2() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lHas = dfs(root.left, p, q);
        boolean rHas = dfs(root.right, p, q);
        if (lHas && rHas) {
            ans = root;
        }else if ((lHas || rHas) && (root.val == p.val || root.val == q.val)) {
            ans = root;
        } else if (lHas) {
            dfs(root.left, p, q);
        } else if (rHas){
            dfs(root.right, p, q);
        }
        if (root.val == p.val || root.val == q.val) {
            return true;
        } else {
            return lHas || rHas;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }
}
