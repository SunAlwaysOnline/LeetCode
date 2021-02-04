package leetcode.medium.phase4;

import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/04 10:15:01
 * 366. 寻找二叉树的叶子节点
 *
 * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
 *
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 *  
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 输出: [[4,5,3],[2],[1]]
 *  
 *
 * 解释:
 *
 * 1. 删除叶子节点 [4,5,3] ，得到如下树结构：
 *
 *           1
 *          /
 *         2
 *  
 *
 * 2. 现在删去叶子节点 [2] ，得到如下树结构：
 *
 *           1
 *  
 *
 * 3. 现在删去叶子节点 [1] ，得到空树：
 *
 *           []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-leaves-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number366 {

    public static class TreeNode {
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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        int depth = depth(root);
        for (int i = 0; i < depth; i++) {
            res.add(new ArrayList<>());
        }
        fill(root);
        return res;
    }

    private void fill(TreeNode node) {
        if (node == null) {
            return;
        }
        int depth = depth(node);
        res.get(depth - 1).add(node.val);
        fill(node.left);
        fill(node.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //-------------------------------------------------------

//    int depth = 0;
//    TreeNode pre;
//    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//
//    private void recall(TreeNode node) {
//        if (node == null) {
//            List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
//            list.add(pre.val);
//            map.put(depth, list);
//            return;
//        }
//        depth++;
//        pre = node;
//        recall(node.left);
//        recall(node.right);
//        depth--;
//    }
//
//    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(6);
//        TreeNode n7 = new TreeNode(7);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n4;
//        n2.right = n5;
//
//        n3.left = n6;
//        n3.right = n7;
//
//        //       1
//        //     /   \
//        //    2     3
//        //  /  \   / \
//        // 4   5  6   7
//
//        Number366 number366 = new Number366();
//        number366.recall(n1);
//
//    }

}
