package leetcode.medium.phase6;

import datastructure.BinaryTree;
import method.BFS;
import method.Classic;
import method.Recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/01/15 11:19:52
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 */
@BinaryTree
@Classic
public class Number513 {

    public class TreeNode {
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

    @BFS
    public int findBottomLeftValue1(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    int res = -1;
    int maxDepth = -1;

    @Recursion
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        dfs(node.left, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            res = node.val;
        }
        dfs(node.right, depth + 1);
    }

}
