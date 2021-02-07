package leetcode.easy.phase6;

import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author qcy
 * @create 2021/02/07 10:38:07
 * 590. N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(0, node.val);
            if (node.children != null) {
                for (Node item : node.children) {
                    stack.push(item);
                }
            }
        }
        return list;
    }

}
