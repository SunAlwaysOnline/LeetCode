package leetcode.medium.phase13;

import datastructure.Grid;
import method.Classic;
import method.DFS;

/**
 * @author qcy
 * @create 2020/12/29 14:53:10
 * 1254. 统计封闭岛屿的数目
 *
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 *
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 *
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 *
 * 请返回封闭岛屿的数目。
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 *
 *
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 *              [1,1,1,1,1,1,1]]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 */
@Grid
@Classic
public class Number1254 {

    @DFS
    public int closedIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean flag = bfs(grid, i, j);
                    if (flag) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean bfs(int[][] grid, int i, int j) {
        //保证在地图内
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return false;
        }
        //海洋
        if (grid[i][j] == 1) {
            return true;
        }
        //遍历过的陆地
        if (grid[i][j] == 2) {
            return true;
        }
        //标记为被遍历过
        grid[i][j] = 2;

        //上边
        boolean up = bfs(grid, i - 1, j);
        //下边
        boolean down = bfs(grid, i + 1, j);
        //左边
        boolean left = bfs(grid, i, j - 1);
        //右边
        boolean right = bfs(grid, i, j + 1);

        return up && down && left && right;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(new Number1254().closedIsland(grid));
    }
}
