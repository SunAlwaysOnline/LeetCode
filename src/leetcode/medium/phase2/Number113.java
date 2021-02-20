package leetcode.medium.phase2;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/20 10:50:06
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return out;
        }
        this.sum = sum;
        dfs(root);
        return out;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        in.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            out.add(new ArrayList<>(in));
        }
        dfs(node.left);
        dfs(node.right);
        sum += node.val;
        in.remove(in.size() - 1);
    }

    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \    / \
    //        7    2  5   1
    //

}
