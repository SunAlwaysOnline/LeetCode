package important.tree;

import method.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/06/02 16:39:09
 * 之字形遍历二叉树
 */
public class ZLevelOrder {

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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> in = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left) {
                    in.addLast(node.val);
                } else {
                    in.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            out.add(in);
            left = !left;
        }

        return out;
    }

}
