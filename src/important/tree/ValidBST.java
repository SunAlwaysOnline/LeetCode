package important.tree;

/**
 * @author qcy
 * @create 2021/05/18 09:49:02
 * 验证二叉搜索树
 */
public class ValidBST {

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

    //二叉搜索树的中序遍历序列是一个递增的集合
    //那么在中序遍历的过程中,判断当前元素是否比上一个元素大即可
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftValid = isValidBST(root.left);
        if (!leftValid) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }


}
