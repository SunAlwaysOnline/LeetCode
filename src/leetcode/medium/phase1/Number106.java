package leetcode.medium.phase1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/09/25 15:34:43
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Number106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //保存中序遍历数值与下标的映射关系
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    //后序遍历数组
    int[] postOrderArray;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        postOrderArray = postorder;

        return build(0, inorder.length - 1, 0, postorder.length - 1);

    }

    /**
     * @param inOrderStart   中序遍历下标开始值
     * @param inOrderEnd     中序遍历下标结束值
     * @param postOrderStart 后序遍历下标开始值
     * @param postOrderEnd   后序遍历下标结束值
     * @return
     */
    public TreeNode build(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            return null;
        }
        //获取根节点
        int rootValue = postOrderArray[postOrderEnd];
        //根节点在中序遍历中的索引
        int rootIndex = inOrderMap.get(rootValue);
        //构造根节点
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + rootIndex - inOrderStart - 1);
        root.right = build(rootIndex + 1, inOrderEnd, postOrderStart + rootIndex - inOrderStart, postOrderEnd - 1);
        return root;
    }

}
