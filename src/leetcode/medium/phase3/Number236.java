package leetcode.medium.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Orignal;
import method.Recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/08 15:23:53
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class Number236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> pList = new ArrayList<>();
    List<TreeNode> qList = new ArrayList<>();

    @Recall
    @Orignal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        try {
            search(root, p, pList);
        } catch (Exception e) {
        }

        try {
            search(root, q, qList);
        } catch (Exception e) {
        }

        int index = 0;
        //pList:{3,5}
        //qList:{3,5,2,4}
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            index = i;
            if (pList.get(i).val != qList.get(i).val) {
                return pList.get(i - 1);
            }
        }
        return index == pList.size() - 1 ? pList.get(index) : qList.get(index);
    }

    //从root中找到target节点，并将路径保存在list中
    private void search(TreeNode root, TreeNode target, List<TreeNode> list) throws Exception {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.val == target.val) {
            throw new Exception("");
        }
        search(root.left, target, list);
        search(root.right, target, list);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);

        t3.left = t5;

        t5.right = t6;
        t5.left = t2;

        t2.left = t7;
        t2.right = t4;

        System.out.println(new Number236().lowestCommonAncestor(t3, t5, t4).val);
    }

}
