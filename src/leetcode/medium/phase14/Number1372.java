package leetcode.medium.phase14;

import datastructure.BinaryTree;
import method.Classic;
import method.DP;

/**
 * @author qcy
 * @create 2021/03/09 16:00:02
 * 1372. 二叉树中的最长交错路径
 *
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 *
 *
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@DP
public class Number1372 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //res[0]表示当前节点下一步向左走带来的最大收益，res[1]表示当前节点下一步向右走带来的最大收益
    //res[0]=1+left[1] 当前节点下一步向左走带来的最大收益等于左子节点向右走的最大收益+1
    //res[1]=1+right[0] 当前节点下一步向右走带来的最大收益等于右子节点向左走的最大收益+1
    //
    //维护一个全局变量maxPath，每次遍历某一节点时，更新它

    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root);
        return max;
    }

    private int[] help(TreeNode node) {
        int[] res = new int[]{-1, -1};
        if (node == null) {
            return res;
        }
        int[] left = help(node.left);
        int[] right = help(node.right);

        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }


    public static void main(String[] args) {
    }
}
