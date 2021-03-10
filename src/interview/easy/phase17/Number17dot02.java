package interview.easy.phase17;

import datastructure.BinaryTree;
import datastructure.LinkedList;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/10 10:39:09
 * 面试题 17.12. BiNode
 *
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@LinkedList
public class Number17dot02 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode virtualNode = new TreeNode(-1);
    TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return virtualNode.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre == null) {
            virtualNode.right = node;
        } else {
            pre.right = node;
        }
        pre = node;
        node.left = null;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);

        n4.left = n3;
        n3.left = n2;
        n2.left = n1;
        n4.right = n5;

        TreeNode treeNode = new Number17dot02().convertBiNode(n4);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }
}
