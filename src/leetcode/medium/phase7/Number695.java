package leetcode.medium.phase7;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2020/12/31 21:28:35
 * 695. 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * 
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *  
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 */
@Classic
@Grid
public class Number695 {

    int cur = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    boolean dfs = dfs(grid, i, j);
                    if (dfs) {
                        res = Math.max(res, cur);
                    }
                }
            }
        }

        return res;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        //超出边界
        if (i < 0 || i == grid.length | j < 0 || j == grid[0].length) {
            return true;
        }
        //如果是水
        if (grid[i][j] == 0) {
            return true;
        }
        //如果遍历过
        if (grid[i][j] == 2) {
            return true;
        }
        //谁标记为遍历过
        grid[i][j] = 2;
        cur++;

        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        return up && down && left && right;
    }

}
