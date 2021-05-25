package important.tree;

/**
 * @author qcy
 * @create 2021/05/25 15:11:15
 * 最近公共祖先结点
 */
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //该函数的作用是以root为根节点,查找p与q的最近公共祖先结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //到底都没找到
        if (root == null) {
            return null;
        }
        //找到了
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        //在左子树上继续寻找
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        //在右子树上继续寻找
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            //p与q分别位于root的两侧,则root为最近公共祖先节点
            return root;
        }
        if (leftNode == null) {
            //左子树上没找到,说明在root的右子树上
            return rightNode;
        }
        return leftNode;
    }

}
