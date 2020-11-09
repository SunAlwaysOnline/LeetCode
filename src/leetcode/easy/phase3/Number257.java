package leetcode.easy.phase3;

import method.DFS;
import method.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/11/09 13:44:05
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class Number257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Recursion
    @DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        dfs(root.left, res, s + root.val + "->");
        dfs(root.right, res, s + root.val + "->");
    }

}
