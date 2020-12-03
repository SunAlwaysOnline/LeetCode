package leetcode.easy.phase6;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Optimal;
import method.Orignal;
import method.Recursion;
import method.Violence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/12/03 09:19:37
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
public class Number501 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Orignal
    @Violence
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //二叉搜索树的中序遍历是一个非递减的集合
        List<Integer> list = new ArrayList<>();
        inOrder1(root, list);

        if (list.size() == 1) {
            return new int[]{list.get(0)};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int maxTime = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxTime) {
                res.add(entry.getKey());
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder1(root.left, list);
        list.add(root.val);
        inOrder1(root.right, list);
    }

    int cur = 0;
    int curCount = 0;
    int maxCount = 0;
    List<Integer> res = new ArrayList<>();

    @Optimal
    @Recursion
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //二叉搜索树的中序遍历是一个非递减的集合
        inOrder(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        update(root.val);
        inOrder(root.right);
    }

    private void update(int num) {
        if (num == cur) {
            curCount++;
        } else {
            cur = num;
            curCount = 1;
        }
        if (curCount == maxCount) {
            res.add(num);
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            res.clear();
            res.add(num);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);

        n1.left = null;
        n1.right = n2;
        n2.right = n3;

        new Number501().findMode(n1);
    }

}
