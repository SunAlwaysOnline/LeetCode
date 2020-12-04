package jzoffer.phase1;

import method.Orignal;
import method.Violence;

/**
 * @author qcy
 * @create 2020/12/04 13:47:19
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 *
 */
public class Number55dot2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Violence
    @Orignal
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        int leftDepth = depth(root.left);
        int rigthDepth = depth(root.right);
        if (Math.abs(leftDepth - rigthDepth) > 1) {
            return false;
        }
        return true;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
