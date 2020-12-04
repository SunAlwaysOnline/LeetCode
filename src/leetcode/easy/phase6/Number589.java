package leetcode.easy.phase6;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Orignal;
import method.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/04 15:09:59
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 */
public class Number589 {

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

    List<Integer> res = new ArrayList<>();

    @Recursion
    @Orignal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        recursion(root);
        return res;
    }

    private void recursion(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);

        for (Node item : root.children) {
            recursion(item);
        }
    }

}
