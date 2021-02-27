package leetcode.medium.phase5;

import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;

/**
 * @author qcy
 * @create 2021/02/25 15:22:38
 * 437. 路径总和 III
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number437 {

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

    int count = 0;

    //@SpaceComplexity("O(h)")
    @TimeComplexity("O(n^2)")
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        cal(node, sum);
        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    private void cal(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        if (sum == 0) {
            count++;
        }
        cal(node.left, sum);
        cal(node.right, sum);
    }
}
