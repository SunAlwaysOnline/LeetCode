package leetcode.easy.phase2;

import method.Orignal;

/**
 * @author qcy
 * @create 2020/11/13 15:14:15
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Number110 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Orignal
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int distance = Math.abs(depth(root.left) - depth(root.right));
        if (distance > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t4.left = t5;

        System.out.println(new Number110().isBalanced(t1));
    }

}
