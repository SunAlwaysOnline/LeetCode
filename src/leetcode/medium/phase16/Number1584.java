package leetcode.medium.phase16;

import method.Classic;
import method.UF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/10 16:36:50
 * 1584. 连接所有点的最小费用
 *
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@UF
public class Number1584 {

    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int length = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge edge = new Edge(i, j, length);
                list.add(edge);
            }
        }

        list.sort(Comparator.comparingInt(a -> a.length));

        UF uf = new UF(points.length);
        int cost = 0;
        for (Edge edge : list) {
            boolean union = uf.union(edge.a, edge.b);
            if (union) {
                cost += edge.length;
            }
            if (uf.circle == 1) {
                return cost;
            }
        }
        return -1;
    }

    class UF {
        int circle;
        int[] pre;

        public UF(int n) {
            circle = n;
            pre = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = i;
            }
        }

        private int findRoot(int i) {
            while (pre[i] != i) {
                i = pre[i];
            }
            return i;
        }

        private boolean union(int a, int b) {
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            if (aRoot == bRoot) {
                return false;
            }
            pre[aRoot] = bRoot;
            circle--;
            return true;
        }
    }

    class Edge {
        int a;
        int b;
        int length;

        public Edge(int a, int b, int length) {
            this.a = a;
            this.b = b;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        int[][] points = {
                {-14, -14},
                {-18, 5},
                {18, -10},
                {18, 18},
                {10, -2}
        };
        System.out.println(new Number1584().minCostConnectPoints(points));
    }

}
