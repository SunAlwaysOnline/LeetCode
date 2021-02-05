package leetcode.medium.phase13;

import datastructure.BinaryTree;
import method.Classic;
import method.WaitForUnderstand;

/**
 * @author qcy
 * @create 2021/02/05 11:22:04
 * 1261. 在受污染的二叉树中查找元素
 *
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * 示例 2：
 *
 *
 *
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * 示例 3：
 *
 *
 *
 * 输入：
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * 输出：
 * [null,true,false,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 *  
 *
 * 提示：
 *
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1261 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class FindElements {
        TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
            root.val = 0;
            preOrder(root);
        }

        private void preOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            int val = node.val;
            if (node.left != null) {
                node.left.val = 2 * val + 1;
            }
            if (node.right != null) {
                node.right.val = 2 * val + 2;
            }
            preOrder(node.left);
            preOrder(node.right);
        }

        public boolean find(int target) {
            return find(root, target);
        }

        private boolean find(TreeNode node, int target) {
            if (node == null) {
                return false;
            }
            if (node.val == target) {
                return true;
            }
            return find(node.left, target) || find(node.right, target);
        }

        @WaitForUnderstand
        public boolean find1(int target) {
            if (target < 0) {
                return false;
            }

            TreeNode node = root;
            target++; // 将target加1，用以表示转换树中的值
            int bit = Integer.highestOneBit(target); // 找到次高位开始计算
            bit = bit >> 1;

            while (bit > 0 && node != null) {
                if ((target & bit) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                bit >>= 1;
            }

            return node != null;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-1);
        n1.right = n2;
        Number1261 number1261 = new Number1261();
        FindElements findElements = number1261.new FindElements(n1);
        System.out.println(findElements.find1(2));
    }

}
