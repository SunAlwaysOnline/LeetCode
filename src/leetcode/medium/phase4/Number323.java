package leetcode.medium.phase4;

import method.Classic;
import method.UF;

/**
 * @author qcy
 * @create 2021/03/11 14:27:42
 * 323. 无向图中连通分量的数目
 *
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 *
 * 示例 1:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * 输出:  1
 * 注意:
 * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@UF
public class Number323 {

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.remain;
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

        private void union(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                return;
            }
            parent[aParent] = bParent;
            remain--;
        }
    }

}
