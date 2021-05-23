package important.tree;

/**
 * @author qcy
 * @create 2021/05/23 19:42:05
 * 判断二叉树是否平衡
 */
public class JudgeBalancedBinaryTree {

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

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    //自底向上,将平衡性向上传递
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
