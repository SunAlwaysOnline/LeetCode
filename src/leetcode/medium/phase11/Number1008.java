package leetcode.medium.phase11;

import datastructure.BinaryTree;
import method.Classic;
import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/02/05 16:28:18
 * 1008. 前序遍历构造二叉搜索树
 *
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，
 * 值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，
 * 然后遍历 node.left，接着遍历 node.right。）
 *
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 *
 *
 * 示例：
 *
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *  
 *
 * 提示：
 *
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * preorder 中的值互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1008 {

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int[] preOrder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preOrder = preorder;
        int[] inOrder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inOrder);
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return create(0, 0, preorder.length - 1);
    }

    private TreeNode create(int preRootIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = preOrder[preRootIndex];
        int inOrderIndex = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = create(preRootIndex + 1, inLeft, inOrderIndex - 1);
        root.right = create(preRootIndex + (inOrderIndex - 1 - inLeft + 1) + 1, inOrderIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        //前序[8,5,1,7,10,12]
        //中序[1,5,7,8,10,12]
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode treeNode = new Number1008().bstFromPreorder(preorder);
        TreeUtil.print(treeNode);
    }
}
