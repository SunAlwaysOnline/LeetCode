package leetcode.medium.phase2;

import method.BinarySearch;
import method.Classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/22 09:24:11
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinarySearch
public class Number145 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || (!stack.empty())) {
            if (root != null) {
                list.add(root.val);//步骤一，取根节点的值
                stack.push(root);//把根节点放入栈中
                root = root.left;//步骤二，遍历左子树
            } else {
                TreeNode temp = stack.pop();
                root = temp.right;//步骤三，遍历右子树
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || (!stack.empty())) {
            if (root != null) {
                stack.push(root);//把根节点放入栈中
                root = root.left;//步骤一，遍历左子树
            } else {
                TreeNode temp = stack.pop();
                list.add(temp.val);//步骤二，取根结点的值
                root = temp.right;//步骤三，遍历右子树
            }
        }
        return list;
    }

    //后续遍历即对(中，右，左)的翻转
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode temp = stack.pop();
                root = temp.left;
            }
        }
        Collections.reverse(list);

        return list;
    }

}
