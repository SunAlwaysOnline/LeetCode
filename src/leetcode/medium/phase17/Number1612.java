package leetcode.medium.phase17;

import datastructure.BinaryTree;
import method.Classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/02/04 15:18:25
 * 1612. 检查两棵二叉表达式树是否等价
 *
 * 二叉表达式树是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。 
 * 叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 个子节点的节点）表示运算符。
 * 在本题中，我们只考虑 '+' 运算符（即加法）。
 *
 * 给定两棵二叉表达式树的根节点 root1 和 root2 。如果两棵二叉表达式树等价，返回 true ，否则返回 false 。
 *
 * 当两棵二叉搜索树中的变量取任意值，分别求得的值都相等时，我们称这两棵二叉表达式树是等价的。
 *
 * 进阶：当你的答案需同时支持 '-' 运算符（减法）时，你该如何修改你的答案？
 *
 *  
 * 示例 1:
 *
 * 输入： root1 = [x], root2 = [x]
 * 输出： true
 * 示例 2:
 *
 *
 * 输入：root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,c]
 * 输出：true
 * 解释：a + (b + c) == (b + c) + a
 * 示例 3:
 *
 *
 * 输入： root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,d]
 * 输出： false
 * 解释： a + (b + c) != (b + d) + a
 *  
 *
 * 提示：
 *
 * 两棵树中的节点个数相等，且节点个数为范围 [1, 4999] 内的奇数。
 * Node.val 是 '+' 或小写英文字母。
 * 给定的树保证是有效的二叉表达式树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-two-expression-trees-are-equivalent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number1612 {

    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Character, Integer> map = new HashMap<>();
    boolean stop = false;

    public boolean checkEquivalence(Node root1, Node root2) {
        inOrder(root1, true);
        inOrder(root2, false);
        if (stop) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(Node node, boolean flag) {
        if (node == null || stop) {
            return;
        }
        inOrder(node.left, flag);
        char val = node.val;
        if (flag) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        } else {
            Integer value = map.get(val);
            if (value == null) {
                stop = true;
            } else {
                map.put(val, value - 1);
            }
        }
        inOrder(node.right, flag);
    }

    public static void main(String[] args) {
        Node n1 = new Node('+');
        Node n2 = new Node('a');
        Node n3 = new Node('+');
        Node n4 = new Node('b');
        Node n5 = new Node('c');

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;


        Node n6 = new Node('+');
        Node n7 = new Node('+');
        Node n8 = new Node('a');
        Node n9 = new Node('b');
        Node n10 = new Node('c');

        n6.left = n7;
        n6.right = n8;
        n7.left = n9;
        n7.right = n10;

        System.out.println(new Number1612().checkEquivalence(n1, n6));
    }

}
