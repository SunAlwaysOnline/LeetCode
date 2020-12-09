package jzoffer.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.Optimal;

/**
 * @author qcy
 * @create 2020/12/09 16:40:27
 * 剑指 Offer 27. 二叉树的镜像
 *
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 */
@Classic
public class Number27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Optimal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = right;
            root.right = left;

            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

}
