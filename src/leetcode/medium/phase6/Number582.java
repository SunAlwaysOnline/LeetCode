package leetcode.medium.phase6;

import datastructure.BinaryTree;
import method.Classic;
import util.ListUtil;

import java.util.*;

/**
 * @author qcy
 * @create 2021/03/15 16:09:41
 * 582. 杀掉进程
 *
 * 系统中存在 n 个进程，形成一个有根树结构。给你两个整数数组 pid 和 ppid ，
 * 其中 pid[i] 是第 i 个进程的 ID ，ppid[i] 是第 i 个进程的父进程 ID 。
 *
 * 每一个进程只有 一个父进程 ，但是可能会有 一个或者多个子进程 。只有一个进程的 ppid[i] = 0 ，意味着这个进程 没有父进程 。
 *
 * 当一个进程 被杀掉 的时候，它所有的子进程和后代进程都要被杀掉。
 *
 * 给你一个整数 kill 表示要杀掉​​进程的 ID ，返回杀掉该进程后的所有进程 ID 的列表。可以按 任意顺序 返回答案。
 *
 *  
 * 示例 1：
 *
 *
 * 输入：pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
 * 输出：[5,10]
 * 解释：涂为红色的进程是应该被杀掉的进程。
 * 示例 2：
 *
 * 输入：pid = [1], ppid = [0], kill = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * n == pid.length
 * n == ppid.length
 * 1 <= n <= 5 * 104
 * 1 <= pid[i] <= 5 * 104
 * 0 <= ppid[i] <= 5 * 104
 * 仅有一个进程没有父进程
 * pid 中的所有值 互不相同
 * 题目数据保证 kill 在 pid 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kill-process
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number582 {

    class TreeNode {
        int val;
        List<TreeNode> children;

        TreeNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public int getVal() {
            return val;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int p : pid) {
            map.put(p, new TreeNode(p));
        }
        for (int i = 0; i < ppid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            if (pp == 0) {
                continue;
            }
            map.get(pp).children.add(map.get(p));
        }

        dfs(map.get(kill));

        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (TreeNode t : node.children) {
            dfs(t);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Number582().killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5);
        ListUtil.print(list);
    }

}
