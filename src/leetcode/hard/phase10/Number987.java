package leetcode.hard.phase10;

import datastructure.BinaryTree;
import method.Classic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/03/28 18:31:55
 * 987. 二叉树的垂序遍历
 *
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。
 * 树的根结点位于 (0, 0) 。
 *
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。
 * 如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 *
 * 返回二叉树的 垂序遍历 序列。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 *           1 在上面，所以它出现在前面。
 *           5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 *
 *
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 *  
 *
 * 提示：
 *
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number987 {

    public class TreeNode {
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, String> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, "0,0");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String[] split = map.get(node).split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, (x + 1) + "," + (y - 1));
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, (x + 1) + "," + (y + 1));
            }
        }

        Map<Integer, List<TreeNode>> orderMap = new TreeMap<>();
        for (Map.Entry<TreeNode, String> entry : map.entrySet()) {
            int y = Integer.parseInt(entry.getValue().split(",")[1]);
            orderMap.computeIfAbsent(y, v -> new ArrayList<>()).add(entry.getKey());
        }

        List<List<Integer>> out = new ArrayList<>();
        for (Map.Entry<Integer, List<TreeNode>> entry : orderMap.entrySet()) {
            List<TreeNode> nodeList = entry.getValue();
            nodeList.sort((a, b) -> {
                String[] aSplit = map.get(a).split(",");
                int ax = Integer.parseInt(aSplit[0]);
                String[] bSplit = map.get(b).split(",");
                int bx = Integer.parseInt(bSplit[0]);

                return ax != bx ? ax - bx : a.val - b.val;
            });
            out.add(nodeList.stream().map(node -> node.val).collect(Collectors.toList()));
        }

        return out;
    }

}
