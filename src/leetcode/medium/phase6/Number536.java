package leetcode.medium.phase6;

import datastructure.BinaryTree;
import method.Classic;
import result.Incorrect;
import util.TreeUtil;
import util.TreeUtil.TreeNode;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/01/30 19:44:20
 */
@Classic
@BinaryTree
@Incorrect
public class Number536 {


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

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        return create(new StringBuilder(s));
    }

    private TreeNode create(StringBuilder sb) {
        if (sb.length() == 0) {
            return null;
        }
        //根节点
        int rootVal;
        boolean isLesThanZero = false;
        if (sb.charAt(0) == '-') {
            rootVal = Integer.parseInt(sb.substring(0, 2));
            isLesThanZero = true;
        } else {
            rootVal = Integer.parseInt(sb.substring(0, 1));
        }
        TreeNode root = new TreeNode(rootVal);
        if (rootVal < 0 && sb.length() == 2) {
            return root;
        }
        if (rootVal >= 0 && sb.length() == 1) {
            return root;
        }


        //左子树序列
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (true) {
            char ch = sb.charAt(index);
            if (ch != '(' && ch != ')') {
                index++;
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(ch);
                index++;
            } else {
                Character peek = stack.peek();
                if (peek == '(' && ch == ')') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                } else {
                    stack.push(ch);
                }
                index++;
            }
        }

        StringBuilder leftSb = new StringBuilder(sb.substring(isLesThanZero ? 3 : 2, index));
        root.left = create(leftSb);
        if (index == sb.length() - 1) {
            root.right = null;
        } else {
            StringBuilder rightSb = new StringBuilder(sb.substring(index + 2, sb.length() - 1));
            root.right = create(rightSb);
        }
        return root;
    }


    //输入："4(2(3)(1))(6(5))"
    //输出：返回代表下列二叉树的根节点:
    //
    //       4
    //     /   \
    //    2     6
    //   / \   /
    //  3   1 5
    //
    public static void main(String[] args) {
        String s = "-4(2(3)(1))(6(5))";
        TreeNode treeNode = new Number536().str2tree(s);
        TreeUtil.print(treeNode);
    }
}
