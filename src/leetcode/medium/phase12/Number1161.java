package leetcode.medium.phase12;

import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/01/12 10:23:42
 * 1161. 最大层内元素和
 *
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 *
 */
@Classic
@BinaryTree
public class Number1161 {

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

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        int max = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
            if (cur > max) {
                res = level;
                max = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //         [989,null,10250,98693,-89388,null,null,null,-32127]
        //        /   \
        //    null    10250
        //    /  \      /  \
        //98693 -89388 null null
    }

}
