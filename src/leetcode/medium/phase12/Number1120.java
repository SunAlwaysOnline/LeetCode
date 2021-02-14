package leetcode.medium.phase12;

import datastructure.BinaryTree;
import method.Classic;

/**
 * @author qcy
 * @create 2021/02/14 16:44:58
 * 1120. 子树的最大平均值
 *
 * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
 *
 * 子树是树中的任意节点和它的所有后代构成的集合。
 *
 * 树的平均值是树中节点值的总和除以节点数。
 * 
 *
 * 示例：
 *
 *
 * 输入：[5,6,1]
 * 输出：6.00000
 * 解释：
 * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
 * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
 * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
 * 所以答案取最大值 6。
 *  
 *
 * 提示：
 *
 * 树中的节点数介于 1 到 5000之间。
 * 每个节点的值介于 0 到 100000 之间。
 * 如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1120 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    double max = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode node) {
        int[] ans = new int[2];
        if (node == null) {
            return ans;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        ans[0] = left[0] + right[0] + node.val;
        ans[1] = left[1] + right[1] + 1;
        max = Math.max(max, ans[0] / (double) ans[1]);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);

        n1.right = n2;

        double val = new Number1120().maximumAverageSubtree(n1);
        System.out.println(val);
    }

}
