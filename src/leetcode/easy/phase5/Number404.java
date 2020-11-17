package leetcode.easy.phase5;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/11/17 15:49:27
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class Number404 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumOfLeftLeaves1(TreeNode root) {
        return dfs(root);
    }

    @Orignal
    @DFS
    @Recursion
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public int dfs(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && isLeafNode(root.left)) {
            res += root.left.val;
        } else {
            res += dfs(root.left);
        }

        if (root.right != null && !isLeafNode(root.right)) {
            res += dfs(root.right);
        }
        return res;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    @Iteration
    @BFS
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    res += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null && !isLeafNode(node.right)) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        t7.left = t2;

        System.out.println(new Number404().sumOfLeftLeaves(t3));
    }
}
