package leetcode.easy.phase7;

import method.DFS;

/**
 * @author qcy
 * @create 2020/09/23 16:46:47
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 */
public class Number617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @DFS
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //对应位置上的节点为空
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        //对应位置上的节点都不为空
        TreeNode node = new TreeNode(t1.val + t2.val);
        //继续合并左右节点
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

}
