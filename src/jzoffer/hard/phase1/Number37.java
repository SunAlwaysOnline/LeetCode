package jzoffer.hard.phase1;

import method.BinarySearch;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/26 09:25:08
 * 剑指 Offer 37. 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinarySearch
public class Number37 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            StringBuilder sb = new StringBuilder("[");
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null").append(",");
                    continue;
                }
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] array = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(array[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!"null".equals(array[i])) {
                    node.left = new TreeNode(Integer.parseInt(array[i]));
                    queue.offer(node.left);
                }
                i++;
                if (!"null".equals(array[i])) {
                    node.right = new TreeNode(Integer.parseInt(array[i]));
                    queue.offer(node.right);
                }
                i++;
            }

            return root;
        }
    }

}
