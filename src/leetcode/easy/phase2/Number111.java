package leetcode.easy.phase2;

import datastructure.BinaryTree;
import method.BFS;
import method.Classic;
import method.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/23 15:39:00
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 */
@BinaryTree
@Classic
public class Number111 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = Integer.MAX_VALUE;
    int cur = 0;

    @DFS
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs1(root);
        return res;
    }

    private void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        cur++;
        if (node.left == null && node.right == null) {
            res = Math.min(res, cur);
        }
        dfs1(node.left);
        dfs1(node.right);
        cur--;
    }

    //---------------------------------------------------
    int result = Integer.MAX_VALUE;

    @DFS
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs2(root, 0);
        return result;
    }

    private void dfs2(TreeNode node, int cur) {
        if (node == null) {
            return;
        }
        cur++;
        if (node.left == null && node.right == null) {
            result = Math.min(result, cur);
        }
        dfs2(node.left, cur);
        dfs2(node.right, cur);
    }

    //------------------------------------------------------------

    int r = Integer.MAX_VALUE;

    @BFS
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int val = valQueue.poll();
            val++;
            if (node.left == null && node.right == null) {
                r = Math.min(r, val);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                valQueue.offer(val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                valQueue.offer(val);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        //[2,null,3,null,4,null,5,null,6]
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;

        System.out.println(new Number111().minDepth(n1));
    }
}
