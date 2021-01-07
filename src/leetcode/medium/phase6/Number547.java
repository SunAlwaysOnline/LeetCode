package leetcode.medium.phase6;

import method.Classic;
import method.UF;

/**
 * @author qcy
 * @create 2020/09/28 14:13:00
 * 547. 省份数量
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 */
@UF
@Classic
public class Number547 {

    class UF {
        //连通分量个数
        private int count;
        //存储对应的父节点
        private int[] parent;
        //记录每棵树的重量，即树中节点总数
        private int[] size;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        //找出根节点
        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        //判断节点m与n是否连通
        private boolean connect(int m, int n) {
            int rootM = find(m);
            int rootN = find(n);
            return rootM == rootN;
        }

        //连通m与n
        private void union(int m, int n) {
            if (connect(m, n)) {
                return;
            }

            int rootM = find(m);
            int rootN = find(n);
            int sizeM = size[m];
            int sizeN = size[n];

            if (sizeM > sizeN) {
                //m为大树
                parent[rootN] = rootM;
                size[rootM] += size[rootN];
            } else {
                parent[rootM] = rootN;
                size[rootN] += size[rootM];
            }
            count--;
        }

    }

    public int findCircleNum(int[][] M) {
        //有M.length位同学
        UF uf = new UF(M.length);

        for (int i = 0; i < M[0].length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
