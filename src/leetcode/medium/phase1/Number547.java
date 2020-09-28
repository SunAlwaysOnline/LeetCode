package leetcode.medium.phase1;

/**
 * @author qcy
 * @create 2020/09/28 14:13:00
 */
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
