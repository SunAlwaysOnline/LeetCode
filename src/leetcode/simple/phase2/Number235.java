package leetcode.simple.phase2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/09/27 10:51:04
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 */
public class Number235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //时间复杂度取决于访问节点的总数，最坏情况下，树退化为链表，因此时间复杂度为O(n)，n表示树的节点总数
    //空间复杂度取决于路径的长度，因为也为O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);

        TreeNode result = null;

        for (int i = 0; i < Math.min(pPath.size(), qPath.size()) - 1; i++) {
            if (pPath.get(i) == qPath.get(i)) {
                result = pPath.get(i);
            }
        }

        return result;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();

        while (root != null) {
            path.add(root);
            if (root.val == node.val) {
                break;
            }
            if (root.val > node.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        //别忘了将自己加进路径中
        path.add(node);
        return path;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;

        while (true) {
            if (p.val < result.val && q.val < result.val) {
                result = result.left;
            } else if (p.val > result.val && q.val > result.val) {
                result = result.right;
            } else {
                //出现分叉点，即为所求的点
                break;
            }
        }
        return result;
    }

}
