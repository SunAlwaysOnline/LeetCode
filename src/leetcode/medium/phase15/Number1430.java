package leetcode.medium.phase15;

import datastructure.BinaryTree;

import java.util.Objects;

/**
 * @author qcy
 * @create 2021/01/18 16:32:14
 * 1430. 判断给定的序列是否是二叉树从根到叶的路径
 *
 * 给定一个二叉树，我们称从根节点到任意叶节点的任意路径中的节点值所构成的序列为该二叉树的一个 “有效序列” 。
 * 检查一个给定的序列是否是给定二叉树的一个 “有效序列” 。
 *
 * 我们以整数数组 arr 的形式给出这个序列。从根节点到任意叶节点的任意路径中的节点值所构成的序列都是这个二叉树的 “有效序列” 。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * 输出：true
 * 解释：
 * 路径 0 -> 1 -> 0 -> 1 是一个“有效序列”（图中的绿色节点）。
 * 其他的“有效序列”是：
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * 示例 2：
 *
 *
 * 输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * 输出：false
 * 解释：路径 0 -> 0 -> 1 不存在，所以这不是一个“序列”。
 * 示例 3：
 *
 *
 * 输入：root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * 输出：false
 * 解释：路径 0 -> 1 -> 1 是一个序列，但不是一个“有效序列”（译者注：因为序列的终点不是叶节点）。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * 每个节点的值的取值范围是 [0 - 9]
 *
 */
@BinaryTree
public class Number1430 {

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

    int index = 0;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        int length = arr.length;
        if (root == null && length == 0) {
            return true;
        }
        if (root == null || length == 0) {
            return false;
        }
        try {
            dfs(root, arr);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "finish")) {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode node, int[] arr) throws Exception {
        if (node == null) {
            return;
        }
        if (node.val != arr[index]) {
            return;
        }
        index++;
        if (node.left == null && node.right == null && index == arr.length) {
            throw new Exception("finish");
        }
        dfs(node.left, arr);
        dfs(node.right, arr);
        index--;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        //       1
        //     /   \
        //    2     3
        //  /  \   / \
        // 4   5  6   7
        System.out.println(new Number1430().isValidSequence(n1, new int[]{1, 3, 7}));
    }

}
