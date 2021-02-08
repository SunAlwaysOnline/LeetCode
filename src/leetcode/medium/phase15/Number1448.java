package leetcode.medium.phase15;

import datastructure.BinaryTree;
import method.Classic;
import method.Optimal;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/02/08 15:16:58
 * 1448. 统计二叉树中好节点的数目
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * 示例 2：
 *
 *
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 *  
 *
 * 提示：
 *
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1448 {

    public static class TreeNode {
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

    Stack<Integer> stack = new Stack<>();
    int count = 0;

    public int goodNodes1(TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (stack.isEmpty()) {
            stack.push(node.val);
            count++;
        } else {
            if (node.val >= stack.peek()) {
                stack.push(node.val);
                count++;
            } else {
                stack.push(stack.peek());
            }
        }
        dfs(node.left);
        dfs(node.right);
        stack.pop();
    }

//----------------------------------------------------------------------

    int sum = 0;

    @Optimal
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return sum;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            max = node.val;
            sum++;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        System.out.println(new Number1448().goodNodes(n1));
    }
}
