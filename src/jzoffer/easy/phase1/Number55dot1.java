package jzoffer.easy.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Iteration;
import method.Recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/11/24 13:48:15
 * 剑指 Offer 55 - I. 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Number55dot1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //n为节点总数
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    @Recursion
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    //n为节点总数
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    @Iteration
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            maxDepth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }

}
