package leetcode.medium.phase3;

import datastructure.BinaryTree;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/03 10:22:50
 * 298. 二叉树最长连续序列
 *
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
 *
 * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
 *
 * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
 *
 * 示例 1：
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * 输出: 3
 *
 * 解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
 * 示例 2：
 *
 * 输入:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * 输出: 2
 *
 * 解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number298 {

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

    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cal(root);
        return max;
    }

    private int cal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = cal(node.left);
        int right = cal(node.right);

        if (node.left != null && node.left.val == node.val + 1) {
            left++;
        } else {
            left = 0;
        }
        if (node.right != null && node.right.val == node.val + 1) {
            right++;
        } else {
            right = 0;
        }
        if (left == 0 && right == 0) {
            return 1;
        }
        int leftAndRigthMax = Math.max(left, right);
        max = Math.max(max, leftAndRigthMax);
        return leftAndRigthMax;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);

        n1.right = n2;
        n2.left = n3;
        n3.left = n4;

        System.out.println(new Number298().longestConsecutive(n1));
    }
}
