package leetcode.medium.phase2;

import datastructure.BinaryTree;
import datastructure.LinkedList;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/08 17:29:14
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@LinkedList
public class Number114 {

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

    //原始树
    //       1
    //      / \
    //     2   5
    //    / \   \
    //   3   4   6
    //
    //将1的右子树接到1左子树最右下结点的右子树上
    //       1
    //      /
    //     2
    //    / \
    //   3   4
    //        \
    //         5
    //          \
    //           6
    //
    ////将1的左子树变为1的右子树.当前结点变为1的右子节点2,重复前面两个步骤.
    //    1
    //     \
    //      2
    //     / \
    //    3   4
    //         \
    //          5
    //           \
    //            6
    //
    //将2的右子树接到2左子树最右下结点的右子树上
    //    1
    //     \
    //      2
    //     /
    //    3
    //     \
    //      4
    //       \
    //        5
    //         \
    //          6
    //
    //将2的左子树变为2的右子树.一直向下遍历，如果当前结点没左子树则继续向下.
    //    1
    //     \
    //      2
    //       \
    //        3
    //         \
    //          4
    //           \
    //            5
    //             \
    //              6
    //
    public void flatten(TreeNode root) {
        while (root != null) {
            //如果左子树为空，则直接考虑下一个
            if (root.left == null) {
                root = root.right;
                continue;
            }
            //找到左子树的最右结点
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            //将原来右子树的结点接到最右节点上
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
            //继续下一个结点
            root = root.right;
        }
    }

}
