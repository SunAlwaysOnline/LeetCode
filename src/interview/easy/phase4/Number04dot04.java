package interview.easy.phase4;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.*;

/**
 * @author qcy
 * @create 2020/12/23 10:18:28
 */
@BinaryTree
@Classic
public class Number04dot04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @TopDown
    @DoubleCount
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n^2)")
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth1(root.left);
        int rightDepth = getDepth1(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getDepth1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth1(node.left), getDepth1(node.right)) + 1;
    }

    //-------------------------------------------------------------------------------------

    @DownTop
    @Violence
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) > 0;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        //[1,2,2,3,3,null,null,4,4]

    }

}
