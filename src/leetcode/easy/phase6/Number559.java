package leetcode.easy.phase6;

import method.DFS;

import java.util.List;

/**
 * @author qcy
 * @create 2020/09/23 14:33:27
 * 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class Number559 {

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

    @DFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int rootMaxDepth = 0;
        for (Node children : root.children) {
            //递归获取子节点的最大深度
            int childrenMaxDepth = maxDepth(children);
            //更新max值
            rootMaxDepth = Math.max(rootMaxDepth, childrenMaxDepth);
        }
        return rootMaxDepth + 1;
    }

}
