package jzoffer.easy.phase1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/11/30 10:39:03
 * 剑指 Offer 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 */
public class Number28 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            //每一层中如果节点数为奇数，则必定不对称
            if (queue.size() % 2 == 1) {
                return false;
            }
            TreeNode[] nodes = queue.toArray(new TreeNode[0]);
            int length = nodes.length;
            for (int i = 0; i < length / 2; i++) {
                TreeNode node1 = nodes[i];
                TreeNode node2 = nodes[length - i - 1];
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (nodes[i].val != nodes[length - i - 1].val) {
                    return false;
                }
            }
        }
        return true;
    }

    //迭代解决
    public boolean isSymmetric(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        t2.left = null;
        t2.right = t4;

        t3.left = null;
        t3.right = t7;

        System.out.println(new Number28().isSymmetric(t1));
    }
}
