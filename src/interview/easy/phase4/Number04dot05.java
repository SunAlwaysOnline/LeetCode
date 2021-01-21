package interview.easy.phase4;

import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/21 16:47:53
 * 面试题 04.05. 合法二叉搜索树
 *
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number04dot05 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST1(TreeNode root) {
        order(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void order(TreeNode node) {
        if (node == null) {
            return;
        }
        order(node.left);
        list.add(node.val);
        order(node.right);
    }

    //--------------------------------------------

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left){
            return false;
        }
        if (root.val<=pre){
            return false;
        }
        pre=root.val;
        return isValidBST(root.right);
    }

}
