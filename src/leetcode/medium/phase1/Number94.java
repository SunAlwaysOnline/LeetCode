package leetcode.medium.phase1;

import method.Iteration;
import method.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qcy
 * @create 2020/11/03 13:45:50
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class Number94 {

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

    List<Integer> result;

    public List<Integer> inorderTraversal1(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    @Recursion
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }

    @Iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        new Number94().inorderTraversal(node1).forEach(System.out::println);
    }
}
