package leetcode.medium.phase15;

import datastructure.BinaryTree;
import method.Classic;
import method.Optimal;
import method.Violence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/02/27 18:32:26
 * 1484. 克隆含随机指针的二叉树
 *
 * 给你一个二叉树，树中每个节点都含有一个附加的随机指针，该指针可以指向树中的任何节点或者指向空（null）。
 *
 * 请返回该树的 深拷贝 。
 *
 * 该树的输入/输出形式与普通二叉树相同，每个节点都用 [val, random_index] 表示：
 *
 * val：表示 Node.val 的整数
 * random_index：随机指针指向的节点（在输入的树数组中）的下标；如果未指向任何节点，则为 null 。
 * 该树以 Node 类的形式给出，而你需要以 NodeCopy 类的形式返回克隆得到的树。NodeCopy 类和Node 类定义一致。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [[1,null],null,[4,3],[7,0]]
 * 输出：[[1,null],null,[4,3],[7,0]]
 * 解释：初始二叉树为 [1,null,4,7] 。
 * 节点 1 的随机指针指向 null，所以表示为 [1, null] 。
 * 节点 4 的随机指针指向 7，所以表示为 [4, 3] 其中 3 是树数组中节点 7 对应的下标。
 * 节点 7 的随机指针指向 1，所以表示为 [7, 0] 其中 0 是树数组中节点 1 对应的下标。
 * 示例 2：
 *
 *
 * 输入：root = [[1,4],null,[1,0],null,[1,5],[1,5]]
 * 输出：[[1,4],null,[1,0],null,[1,5],[1,5]]
 * 解释：节点的随机指针可以指向它自身。
 * 示例 3：
 *
 *
 * 输入：root = [[1,6],[2,5],[3,4],[4,3],[5,2],[6,1],[7,0]]
 * 输出：[[1,6],[2,5],[3,4],[4,3],[5,2],[6,1],[7,0]]
 * 示例 4：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 5：
 *
 * 输入：root = [[1,null],null,[2,null],null,[1,null]]
 * 输出：[[1,null],null,[2,null],null,[1,null]]
 *  
 *
 * 提示：
 *
 * tree 中节点数目范围是 [0, 1000]
 * 每个节点的值的范围是 [1, 10^6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clone-binary-tree-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1484 {

    public class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }


    Map<Node, NodeCopy> map = new HashMap<>();

    @Optimal
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        NodeCopy rootCpoy = new NodeCopy(root.val);
        Queue<NodeCopy> copyQueue = new LinkedList<>();
        copyQueue.offer(rootCpoy);
        map.put(root, rootCpoy);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            NodeCopy nodeCopy = copyQueue.poll();
            nodeCopy.random = get(node.random);
            if (node.left != null) {
                queue.offer(node.left);
                NodeCopy nodeCopyLeft = get(node.left);
                nodeCopy.left = nodeCopyLeft;
                copyQueue.offer(nodeCopyLeft);
                map.put(node.left, nodeCopyLeft);
            }
            if (node.right != null) {
                queue.offer(node.right);
                NodeCopy nodeCopyRight = get(node.right);
                nodeCopy.right = nodeCopyRight;
                copyQueue.offer(nodeCopyRight);
                map.put(node.right, nodeCopyRight);
            }
        }

        return rootCpoy;
    }

    private NodeCopy get(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        NodeCopy nodeCopy = new NodeCopy(node.val);
        map.put(node, nodeCopy);
        return nodeCopy;
    }


    @Violence
    public NodeCopy copyRandomBinaryTree1(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node, NodeCopy> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        NodeCopy rootCpoy = new NodeCopy(root.val);
        Queue<NodeCopy> copyQueue = new LinkedList<>();
        copyQueue.offer(rootCpoy);
        map.put(root, rootCpoy);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            NodeCopy nodeCopy = copyQueue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                NodeCopy leftCopy = new NodeCopy(node.left.val);
                nodeCopy.left = leftCopy;
                copyQueue.offer(leftCopy);
                map.put(node.left, leftCopy);
            }
            if (node.right != null) {
                queue.offer(node.right);
                NodeCopy rightCopy = new NodeCopy(node.right.val);
                nodeCopy.right = rightCopy;
                copyQueue.offer(rightCopy);
                map.put(node.right, rightCopy);
            }
        }

        queue.offer(root);
        copyQueue.offer(rootCpoy);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            NodeCopy nodeCopy = copyQueue.poll();
            nodeCopy.random = map.get(node.random);

            if (node.left != null) {
                queue.offer(node.left);
                copyQueue.offer(nodeCopy.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
                copyQueue.offer(nodeCopy.right);
            }
        }

        return rootCpoy;
    }

}
