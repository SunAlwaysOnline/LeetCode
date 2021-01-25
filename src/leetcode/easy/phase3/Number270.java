package leetcode.easy.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Optimal;
import method.Orignal;
import result.Incorrect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/25 09:27:38
 * 270. 最接近的二叉搜索树值
 *
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number270 {

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

    @Orignal
    @Incorrect
    public int closestValue1(TreeNode root, double target) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > target) {
                if (node.left == null) {
                    return node.val;
                }
                if (node.left.val < target) {
                    double diff1 = node.val - target;
                    double diff2 = target - node.left.val;
                    if (diff1 < diff2) {
                        return node.val;
                    }
                    return node.left.val;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    return node.val;
                }
                if (node.right.val > target) {
                    double diff1 = target - node.val;
                    double diff2 = node.right.val - target;
                    if (diff1 < diff2) {
                        return node.val;
                    }
                    return node.right.val;
                }
                node = node.right;
            }
        }
        return -1;
    }

    List<Integer> list;

    @Orignal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int closestValue2(TreeNode root, double target) {
        list = new ArrayList<>();
        dfs(root);

        int first = list.get(0);
        int last = list.get(list.size() - 1);
        if (first >= target) {
            return first;
        }
        if (last <= target) {
            return last;
        }

        for (int i = 1; i < list.size(); i++) {
            int pre = list.get(i - 1);
            int after = list.get(i);
            if (after == target) {
                return after;
            }
            if (pre < target && after > target) {
                double preDiff = target - pre;
                double afterDiff = after - target;
                if (preDiff > afterDiff) {
                    return after;
                }
                return pre;
            }
        }
        return -1;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    @Optimal
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        int left = root.val;
        int right = root.val;
        while (node != null) {
            if (target > node.val) {
                left = node.val;
                node = node.right;
                continue;
            }
            if (target < node.val) {
                right = node.val;
                node = node.left;
                continue;
            }
            return node.val;
        }
        return Math.abs(target - left) < Math.abs(right - target) ? left : right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = null;
        n1.right = n2;

        System.out.println(new Number270().closestValue(n1, 2.5));
    }

}
