package leetcode.hard.phase3;

import datastructure.BinaryTree;
import method.Classic;
import method.InComplete;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/24 14:44:31
 */
@BinaryTree
@Classic
@InComplete
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
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            int allNodeNum = (1 << getDepth(root)) - 1;
            int countNodeNum = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                countNodeNum++;
                if (countNodeNum > allNodeNum) {
                    break;
                }
                if (node == null) {
                    sb.append("null").append(",");
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            while (true) {
                if (sb.length() < 5) {
                    break;
                }
                String s = sb.substring(sb.length() - 5, sb.length());
                if (!s.equals("null,")) {
                    break;
                }
                sb.delete(sb.length() - 5, sb.length());
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || "".equals(data) || "[]".equals(data)) {
                return null;
            }
            String[] split = data.split("\\[")[1].split("]")[0].split(",");
            int allNodeSum = split.length;
            int index = 0;
            int curNodeSum = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
            if (allNodeSum == 1) {
                return root;
            }
            queue.offer(root);

            while (!queue.isEmpty()) {
                curNodeSum++;
                if (curNodeSum > allNodeSum) {
                    break;
                }
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                node.left = getNode(split[index++]);
                node.right = getNode(split[index++]);
                queue.offer(node.left);
                queue.offer(node.right);
                curNodeSum += 2;
            }
            return root;
        }

        private int getDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
        }

        private TreeNode getNode(String num) {
            TreeNode node = null;
            try {
                int val = Integer.parseInt(num);
                node = new TreeNode(val);
            } catch (NumberFormatException e) {
            }
            return node;
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
