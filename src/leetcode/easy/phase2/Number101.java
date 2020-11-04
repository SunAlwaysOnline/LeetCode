package leetcode.easy.phase2;

import method.Iteration;
import method.Recursion;

import java.util.LinkedList;

/**
 * @author qcy
 * @create 2020/10/15 13:39:15
 * <p>
 * 101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Number101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归解决
    @Recursion
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        //两个结点都为null
        if (p == null && q == null) {
            return true;
        }
        //其中一个结点为null
        if (p == null || q == null) {
            return false;
        }
        //两个结点的值不相等
        if (p.val != q.val) {
            return false;
        }
        //继续判断p的左孩子与q的右孩子是否相等,p的右孩子与q的左孩子是否相等
        return check(p.left, q.right) && check(p.right, q.left);
    }

    //迭代解决
    @Iteration
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root.left);
        linkedList.add(root.right);

        while (!linkedList.isEmpty()) {
            TreeNode p = linkedList.removeFirst();
            TreeNode q = linkedList.removeFirst();
            //两个结点都为null
            if (p == null && q == null) {
                continue;
            }
            //其中一个结点为null
            if (p == null || q == null) {
                return false;
            }
            //两个结点的值不相等
            if (p.val != q.val) {
                return false;
            }
            //将处于镜像位置上的结点入队
            linkedList.add(p.left);
            linkedList.add(q.right);

            linkedList.add(p.right);
            linkedList.add(q.left);
        }

        return true;
    }


}
