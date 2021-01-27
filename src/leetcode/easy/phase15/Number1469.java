package leetcode.easy.phase15;

import datastructure.BinaryTree;
import method.Classic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/01/27 15:07:04
 * 1469. 寻找所有的独生节点
 *
 * 二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
 *
 * 给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。数组的顺序 不限 。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,4]
 * 输出：[4]
 * 解释：浅蓝色的节点是唯一的独生节点。
 * 节点 1 是根节点，不是独生的。
 * 节点 2 和 3 有共同的父节点，所以它们都不是独生的。
 * 示例 2：
 *
 *
 * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
 * 输出：[6,2]
 * 输出：浅蓝色的节点是独生节点。
 * 请谨记，顺序是不限的。 [2,6] 也是一种可接受的答案。
 * 示例 3：
 *
 *
 * 输入：root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
 * 输出：[77,55,33,66,44,22]
 * 解释：节点 99 和 88 有共同的父节点，节点 11 是根节点。
 * 其他所有节点都是独生节点。
 * 示例 4：
 *
 * 输入：root = [197]
 * 输出：[]
 * 示例 5：
 *
 * 输入：root = [31,null,78,null,28]
 * 输出：[78,28]
 *  
 *
 * 提示：
 *
 *  tree 中节点个数的取值范围是 [1, 1000]。
 * 每个节点的值的取值范围是 [1, 10^6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-the-lonely-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1469 {

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

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                boolean leftIsNull = true;
                boolean rightIsNull = true;
                if (node.left != null) {
                    queue.offer(node.left);
                    leftIsNull = false;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    rightIsNull = false;
                }

                if (leftIsNull && !rightIsNull) {
                    list.add(node.right.val);
                }
                if (!leftIsNull && rightIsNull) {
                    list.add(node.left.val);
                }
            }
        }

        return list;
    }

}
