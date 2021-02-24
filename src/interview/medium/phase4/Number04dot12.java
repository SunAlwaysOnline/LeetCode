package interview.medium.phase4;

import datastructure.BinaryTree;
import method.Classic;
import method.WaitForOptimize;

/**
 * @author qcy
 * @create 2021/02/24 10:22:10
 * 面试题 04.12. 求和路径
 *
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
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
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@WaitForOptimize
public class Number04dot12 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \    / \
    //        7    2  5   1
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
