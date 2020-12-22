package leetcode.easy.phase11;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.BFS;
import method.Classic;
import method.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/22 14:35:40
 * 1022. 从根到叶的二进制数之和
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 *
 */
@BinaryTree
@Classic
public class Number1022 {


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

    int res = 0;
    int cur = 0;

    @DFS
    @SpaceComplexity("O(h)")
    @TimeComplexity("O(n)")
    public int sumRootToLeaf1(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        cur = (cur << 1) + node.val;
        if (node.left == null && node.right == null) {
            res += cur;
        }
        dfs(node.left);
        dfs(node.right);
        cur = (cur - node.val) >> 1;
    }


    @BFS
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer val = valQueue.poll();
            if (node.left == null && node.right == null) {
                res += val;
                continue;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                valQueue.offer((val << 1) + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                valQueue.offer((val << 1) + node.right.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);

        n1.left = n2;
        n1.right = n3;

        System.out.println(new Number1022().sumRootToLeaf(n1));

    }

}
