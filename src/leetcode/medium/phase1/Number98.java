package leetcode.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;
import method.DFS;

import java.util.Objects;

/**
 * @author qcy
 * @create 2020/12/27 21:49:53
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */
@BinaryTree
@Classic
public class Number98 {

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

    @DFS
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public boolean isValidBST(TreeNode root) {
        try {
            order(root);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "ok")) {
                return false;
            }
            e.printStackTrace();
        }
        return true;
    }

    long pre = Long.MIN_VALUE;

    public void order(TreeNode node) throws Exception {
        if (node == null) {
            return;
        }
        order(node.left);
        if (node.val <= pre) {
            throw new Exception("ok");
        }
        pre = node.val;
        order(node.right);
    }

}
