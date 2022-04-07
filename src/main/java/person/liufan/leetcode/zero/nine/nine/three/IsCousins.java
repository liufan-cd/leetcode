package person.liufan.leetcode.zero.nine.nine.three;

import person.liufan.common.TreeNode;
import person.liufan.common.TreeUtils;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.nine.nine.three
 * @description: 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * @date 2021/5/17
 */
public class IsCousins {
    public static void main(String[] args) {
        IsCousins isCousins = new IsCousins();
        System.out.println(isCousins.isCousins(TreeUtils.deserialize("1,2,3,null,4,null,5"), 4, 5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, root);
        return xParent != yParent && xLayer == yLayer;
    }
    int xLayer, yLayer;
    TreeNode xParent, yParent;
    int currentLayer = 1 << 30;
    int layer = 0;
    int x, y;

    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (layer > currentLayer) {
            return;
        }
        if (xLayer != 0 && yLayer != 0) {
            return;
        }
        if (root.val == x) {
            xLayer = layer;
            xParent = parent;
        }
        if (root.val == y) {
            yLayer = layer;
            yParent = parent;
        }
        layer++;
        dfs(root.left, root);
        dfs(root.right, root);
        layer--;
    }
}
