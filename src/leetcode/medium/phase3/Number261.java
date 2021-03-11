package leetcode.medium.phase3;

/**
 * @author qcy
 * @create 2021/03/11 14:48:13
 * 261. 以图判树
 *
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
 * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 *
 * 示例 1：
 *
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 * 示例 2:
 *
 * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * 输出: false
 * 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，
 * 因此不会同时出现在边列表 edges 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/graph-valid-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number261 {

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            boolean union = uf.union(edge[0], edge[1]);
            if (!union) {
                return false;
            }
        }
        return uf.remain == 1;
    }

    class UF {
        int n;
        int remain;
        int[] parent;

        public UF(int n) {
            this.n = n;
            remain = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int findParent(int i) {
            while (parent[i] != i) {
                i = parent[i];
            }
            return i;
        }

        private boolean union(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                return false;
            }
            parent[aParent] = bParent;
            remain--;
            return true;
        }
    }

}
