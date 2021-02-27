package leetcode.medium.phase2;

import datastructure.BinaryTree;
import method.Classic;
import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/02/26 17:08:17
 */
@Classic
@BinaryTree
@WaitForComplete
public class Number117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        help(root);
        return root;
    }

    private void help(Node node) {

    }

}
