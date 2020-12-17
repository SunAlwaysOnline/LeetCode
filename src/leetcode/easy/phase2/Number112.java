package leetcode.easy.phase2;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/17 10:45:05
 * 112. 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
@BinaryTree
public class Number112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Recursion
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int curVal = valQueue.poll();
            if (curNode.left == null && curNode.right == null) {
                if (curVal == sum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                valQueue.offer(curNode.left.val + curVal);
            }
            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                valQueue.offer(curNode.right.val + curVal);
            }
        }
        return false;
    }

}
