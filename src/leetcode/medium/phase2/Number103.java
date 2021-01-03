package leetcode.medium.phase2;

import datastructure.BinaryTree;
import method.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/01/03 18:00:25
 * 103. 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
@BinaryTree
public class Number103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        boolean left = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> in = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                if (left) {
                    in.addLast(val);
                } else {
                    in.addFirst(val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            left = !left;
            out.add(in);
        }
        return out;
    }


}
