package interview.medium.phase4;

import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/02/02 15:03:19
 * 面试题 04.03. 特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * 
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@datastructure.LinkedList
public class Number04dot03 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new ArrayList<>();
        if (tree == null) {
            return listNodes.toArray(new ListNode[0]);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode virtualNode = new ListNode(-1);
            ListNode cur = virtualNode;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ListNode listNode = new ListNode(node.val);
                cur.next = listNode;
                cur = listNode;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ListNode head = virtualNode.next;
            virtualNode.next = null;
            listNodes.add(head);
        }
        return listNodes.toArray(new ListNode[0]);
    }

}
