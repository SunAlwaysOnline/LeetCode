package leetcode.hard.phase3;

import datastructure.BinaryTree;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/24 14:44:31
 * 297. 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number297 {

    public static class TreeNode {
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

            StringBuilder sb = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        // t3.right = t5;

        Number297 number297 = new Number297();
        Codec codec = number297.new Codec();
        String serialize = codec.serialize(t1);
        TreeNode node = codec.deserialize(serialize);
    }

}
