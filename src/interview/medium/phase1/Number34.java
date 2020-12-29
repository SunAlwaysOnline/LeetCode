package interview.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;
import method.DFS;
import method.Optimal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/29 14:08:52
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 */
@BinaryTree
@Classic
public class Number34 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();

    @Optimal
    @DFS
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return out;
        }
        dfs(root, sum);
        return out;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        in.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            out.add(new ArrayList<>(in));
        }
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
        in.remove(in.size() - 1);
    }

}
