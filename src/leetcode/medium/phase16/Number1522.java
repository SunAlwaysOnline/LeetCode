package leetcode.medium.phase16;

import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/03 14:16:13
 * 1522. N 叉树的直径
 *
 * 给定一棵 N 叉树的根节点 root ，计算这棵树的直径长度。
 *
 * N 叉树的直径指的是树中任意两个节点间路径中 最长 路径的长度。这条路径可能经过根节点，也可能不经过根节点。
 *
 * （N 叉树的输入序列以层序遍历的形式给出，每组子节点用 null 分隔）
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 解释：直径如图中红线所示。
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,null,3,4,null,5,null,6]
 * 输出：4
 * 示例 3：
 *
 *
 * 输入: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出: 7
 *  
 *
 * 提示：
 *
 * N 叉树的深度小于或等于 1000 。
 * 节点的总个数在 [0, 10^4] 间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1522 {

    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    int ans = 0;

    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private int[] dfs(Node node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        for (Node n : node.children) {
            int[] temp = dfs(n);
            int max = temp[0] + 1;
            if (max > res[0]) {
                res[1] = res[0];
                res[0] = max;
            } else if (max > res[1]) {
                res[1] = max;
            }
        }
        ans = Math.max(ans, res[0] + res[1]);
        return res;
    }

}
