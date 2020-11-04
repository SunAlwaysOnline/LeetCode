package leetcode.easy.phase8;

import method.Iteration;
import method.Recursion;

/**
 * @author qcy
 * @create 2020/11/04 09:45:05
 * 700. 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 */
public class Number700 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Iteration
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.val == val) {
                return curNode;
            }
            if (curNode.val > val) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }

        return null;
    }

    @Recursion
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

}
