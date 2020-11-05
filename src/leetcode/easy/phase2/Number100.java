package leetcode.easy.phase2;

import method.*;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/11/03 16:49:10
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 */
public class Number100 {

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

    @Orignal
    @DFS
    @Iteration
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size != 0) {
                TreeNode n1 = stack.pop();
                TreeNode n2 = stack.pop();
                if (n1.val != n2.val) {
                    return false;
                }
                if (n1.left == null && n2.left != null) {
                    return false;
                }
                if (n1.left != null && n2.left == null) {
                    return false;
                }
                if (n1.right == null && n2.right != null) {
                    return false;
                }
                if (n1.right != null && n2.right == null) {
                    return false;
                }
                if (n1.left != null) {
                    stack.push(n1.left);
                    stack.push(n2.left);
                }
                if (n2.right != null) {
                    stack.push(n1.right);
                    stack.push(n2.right);
                }
                size -= 2;
            }
        }

        return true;
    }

    @Recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
