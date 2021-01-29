package leetcode.medium.phase13;

import method.BinarySearch;
import method.Classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/01/29 09:45:40
 * 1214. 查找两棵二叉搜索树之和
 *
 * 给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 *
 * 如果可以找到返回 True，否则返回 False。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
 * 输出：true
 * 解释：2 加 3 和为 5 。
 * 示例 2：
 *
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * 输出：false
 *  
 *
 * 提示：
 *
 * 每棵树上最多有 5000 个节点。
 * -10^9 <= target, node.val <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-bsts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinarySearch
public class Number1214 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Set<Integer> set;
    int target;
    boolean flag;

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        set = new HashSet<>();
        this.target = target;
        flag = false;

        inOrder(root1);
        find(root2);
        return flag;
    }

    private void find(TreeNode node) {
        if (node == null || flag) {
            return;
        }
        find(node.left);
        if (set.contains(node.val)) {
            flag = true;
            return;
        }
        find(node.right);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        set.add(target - node.val);
        inOrder(node.right);
    }

}
