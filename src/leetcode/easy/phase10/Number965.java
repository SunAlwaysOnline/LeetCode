package leetcode.easy.phase10;

import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/28 10:55:55
 * 965. 单值二叉树
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 * 示例 1：
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 */
@BinaryTree
@Classic
public class Number965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int num = 0;

    public boolean isUnivalTree1(TreeNode root) {
        if (root == null) {
            return true;
        }
        num = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != num) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    //----------------------------------------------

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int n) {
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left, n);
        if (!left) {
            return false;
        }
        if (node.val != n) {
            return false;
        }
        return dfs(node.right, n);
    }


}
