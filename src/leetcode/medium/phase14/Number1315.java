package leetcode.medium.phase14;

import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/02/02 14:09:08
 * 1315. 祖父节点值为偶数的节点和
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *  
 *
 * 示例：
 *
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *  
 *
 * 提示：
 *
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1315 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if ((node.val & 1) == 0) {
                    if (node.left != null) {
                        if (node.left.left != null) {
                            sum += node.left.left.val;
                        }
                        if (node.left.right != null) {
                            sum += node.left.right.val;
                        }
                    }
                    if (node.right != null) {
                        if (node.right.left != null) {
                            sum += node.right.left.val;
                        }
                        if (node.right.right != null) {
                            sum += node.right.right.val;
                        }
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

}
