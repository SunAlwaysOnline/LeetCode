package jzoffer.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/23 19:05:58
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
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
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number7 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder;
    //缓存中序遍历中,结点值与下标的关系
    Map<Integer, Integer> dic;

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        dic = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return create(0, 0, inorder.length - 1);
    }

    private TreeNode create(int preRootIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRootIndex]);
        int i = dic.get(preorder[preRootIndex]);
        root.left = create(preRootIndex + 1, inLeftIndex, i - 1);
        //先序遍历中父节点下标+父节点左子树长度+1得到父节点右子树在先序遍历中根节点的
        root.right = create(preRootIndex + (i - 1 - inLeftIndex + 1) + 1, i + 1, inRightIndex);
        return root;
    }

}
