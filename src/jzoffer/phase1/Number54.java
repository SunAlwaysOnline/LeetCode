package jzoffer.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DFS;
import method.Optimal;
import method.Recursion;
import method.Violence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/10 10:11:14
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 */
public class Number54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list1 = new ArrayList<>();

    @Violence
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    @DFS
    @Recursion
    public int kthLargest1(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        dfs1(root);
        int index = list1.size() - 1;
        int cur = Integer.MIN_VALUE;
        while (k != 0) {
            if (list1.get(index) != cur) {
                k--;
            }
            index--;
        }
        if (index + 1 < 0) {
            return -1;
        }
        return list1.get(index + 1);
    }

    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs1(root.left);
        list1.add(root.val);
        dfs1(root.right);
    }

    //---------------------------------------------------------------------------

    int n;
    int res;

    @Optimal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    @DFS
    @Recursion
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        n = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || n == 0) {
            return;
        }
        dfs(root.right);
        if (--n == 0) {
            res = root.val;
        }
        dfs(root.left);
    }


}
