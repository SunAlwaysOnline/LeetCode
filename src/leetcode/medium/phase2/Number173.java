package leetcode.medium.phase2;

import datastructure.BinaryTree;
import method.Classic;
import method.WaitForOptimize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/06 14:04:02
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 
 *
 * 示例：
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 */
@Classic
@BinaryTree
@WaitForOptimize
public class Number173 {

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

    class BSTIterator {
        List<Integer> list;
        Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
            iterator = list.iterator();
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

}
