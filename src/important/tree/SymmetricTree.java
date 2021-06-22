package important.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/06/18 16:31:31
 * 对称二叉树
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //都为null
            if (left == null && right == null) {
                continue;
            }
            //其中一个为null
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;
    }

}
