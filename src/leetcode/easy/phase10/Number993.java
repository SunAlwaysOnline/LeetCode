package leetcode.easy.phase10;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/01/02 22:49:34
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 */
@Classic
@BinaryTree
public class Number993 {

    public class TreeNode {
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

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xFatherNode = null;
        TreeNode yFatherNode = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        xFatherNode = node;
                    }
                    if (node.left.val == y) {
                        yFatherNode = node;
                    }
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xFatherNode = node;
                    }
                    if (node.right.val == y) {
                        yFatherNode = node;
                    }
                }
            }
            if (xFatherNode != null && yFatherNode != null) {
                return xFatherNode.val != yFatherNode.val;
            }
            if (xFatherNode != null || yFatherNode != null) {
                return false;
            }
        }
        return false;
    }

}
