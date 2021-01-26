package leetcode.medium.phase2;

import datastructure.BinaryTree;
import method.Classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/26 09:36:54
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number105 {

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

    //前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    int[] preorder;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return create(0, 0, inorder.length - 1);
    }

    private TreeNode create(int preRootIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }
        int rootVal = preorder[preRootIndex];
        TreeNode root = new TreeNode(rootVal);
        //找出该根节点在中序遍历的索引
        int i = inorderMap.get(rootVal);
        root.left = create(preRootIndex + 1, inLeftIndex, i - 1);
        root.right = create(preRootIndex + (i - 1 - inLeftIndex + 1) + 1, i + 1, inRightIndex);
        return root;
    }


}
