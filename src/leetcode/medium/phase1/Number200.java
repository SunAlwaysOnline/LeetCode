package leetcode.medium.phase1;

import method.DFS;

/**
 * @author qcy
 * @create 2020/09/27 17:48:31
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class Number200 implements DFS {

    //              (m-1,n)
    //      (m,n-1) (m, n ) (m,n+1)
    //              (m+1,n)
    char[][] map;

    public int numIslands(char[][] grid) {
        map = grid;
        int sum = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '1') {
                    sum++;
                    dfs(i, j);
                }
            }
        }

        return sum;
    }

    private void dfs(int m, int n) {
        //如果不在区域中
        if (!inArea(m, n)) {
            return;
        }
        //如果是水
        if (map[m][n] == '0') {
            return;
        }
        //如果已经遍历过
        if (map[m][n] == '2') {
            return;
        }
        //当前位置为陆地，那么设置为访问过
        map[m][n] = '2';
        //一直向上访问
        dfs(m - 1, n);
        //一直向下访问
        dfs(m + 1, n);
        //一直向左访问
        dfs(m, n - 1);
        //一直向右访问
        dfs(m, n + 1);
    }

    //判断是否在网格中
    private boolean inArea(int m, int n) {
        return m >= 0 && m < map.length
                && n >= 0 && n < map[0].length;
    }

    public static void main(String[] args) {
        char[][] map = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = new Number200().numIslands(map);
        System.out.println(i);
    }
}
