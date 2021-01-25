package leetcode.easy.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;
import method.DFS;
import method.Recursion;

/**
 * @author qcy
 * @create 2021/01/25 15:37:32
 * 285. 二叉搜索树中的顺序后继
 *
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 *
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 *
 *  
 * 示例 1:
 *
 *
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * 解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2:
 *
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 * 解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
 *  
 *
 * 注意:
 *
 * 假如给出的结点在该树中没有顺序后继的话，请返回 null
 * 我们保证树中每个结点的值是唯一的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/inorder-successor-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number285 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        return dfs(root, p);
    }

    @DFS
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public TreeNode dfs(TreeNode node, TreeNode p) {
        if (node == null || p == null) {
            return null;
        }
        if (node.val <= p.val) {
            return dfs(node.right, p);
        }
        TreeNode left = dfs(node.left, p);
        if (left != null) {
            return left;
        }
        return node;
    }

    @Recursion
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val <= p.val) {
                cur = cur.right;
                continue;
            }
            if (res == null || res.val > cur.val) {
                res = cur;
            }
            cur = cur.left;
        }
        return res;
    }


}
