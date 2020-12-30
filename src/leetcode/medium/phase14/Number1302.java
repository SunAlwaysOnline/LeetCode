package leetcode.medium.phase14;

import datastructure.BinaryTree;
import method.BFS;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/30 11:08:11
 * 1302. 层数最深叶子节点的和
 *
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * 
 *
 * 示例：
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *  
 *
 * 提示：
 *
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 */
@BinaryTree
@Classic
public class Number1302 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @BFS
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            res = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

}
