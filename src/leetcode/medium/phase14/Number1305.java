package leetcode.medium.phase14;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;
import method.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/03 20:02:52
 * 1305. 两棵二叉搜索树中的所有元素
 *
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 *
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 *
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 示例 5：
 *
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *  
 *
 * 提示：
 *
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 *
 */
@Classic
@BinaryTree
public class Number1305 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    @DFS
    @SpaceComplexity("O(m+n)")
    @TimeComplexity("O(m+n)")
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        if (root1 == null && root2 == null) {
            return res;
        }

        dfs(root1, list1);
        dfs(root2, list2);

        if (root2 == null) {
            return list1;
        }
        if (root1 == null) {
            return list2;
        }

        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.size() && index2 < list2.size()) {
            int val1 = list1.get(index1);
            int val2 = list2.get(index2);

            if (val1 <= val2) {
                res.add(val1);
                index1++;
            } else {
                res.add(val2);
                index2++;
            }
        }

        //list1有剩余
        for (int i = index1; i < list1.size(); i++) {
            res.add(list1.get(i));
        }
        //list2有剩余
        for (int i = index2; i < list2.size(); i++) {
            res.add(list2.get(i));
        }

        return res;
    }

    //二叉搜索树的中序遍历为非递减序列
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n59 = new TreeNode(59);
        TreeNode n57 = new TreeNode(57);
        TreeNode n90 = new TreeNode(90);

        n0.right = n59;
        n59.left = n57;
        n59.right = n90;

        TreeNode n60 = new TreeNode(60);
        TreeNode n17 = new TreeNode(17);
        TreeNode n74 = new TreeNode(74);
        TreeNode n6 = new TreeNode(6);
        TreeNode n20 = new TreeNode(20);
        TreeNode n63 = new TreeNode(63);
        TreeNode n97 = new TreeNode(97);
        TreeNode n95 = new TreeNode(95);

        n60.left = n17;
        n60.right = n74;
        n17.left = n6;
        n17.right = n20;
        n74.left = n63;
        n74.right = n97;
        n97.left = n95;

        new Number1305().getAllElements(n0, n60);

    }

}
