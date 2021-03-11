package leetcode.medium.phase14;

import method.Classic;
import method.UF;

/**
 * @author qcy
 * @create 2021/03/11 14:07:37
 * 1319. 连通网络的操作次数
 *
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，
 * 其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
 * 请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 *
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@UF
public class Number1319 {

    public int makeConnected(int n, int[][] connections) {
        UF uf = new UF(n);
        //多余的线
        int unnecessaryEdge = 0;
        for (int[] connection : connections) {
            boolean union = uf.union(connection[0], connection[1]);
            if (!union) {
                unnecessaryEdge++;
            }
        }
        int remain = uf.remain;
        //刚好连通所有的节点
        if (remain == 1) {
            return 0;
        }
        //剩下的线不够连通所有的节点
        if (remain - 1 > unnecessaryEdge) {
            return -1;
        }
        return remain - 1;
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

    public static void main(String[] args) {
        System.out.println(new Number1319().makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
    }

}
