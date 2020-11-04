package leetcode.easy.phase5;

import method.DFS;

/**
 * @author qcy
 * @create 2020/11/04 10:20:57
 * 463. 岛屿的周长
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class Number436 {

    public int islandPerimeter1(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        result -= 2;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        result -= 2;
                    }
                }
            }
        }

        return result;
    }

    @DFS
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        //遇到边界
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
            return 1;
        }
        //遇到水域
        if (grid[i][j] == 0) {
            return 1;
        }
        //已经被访问过
        if (grid[i][j] == 2) {
            return 0;
        }
        //标记为访问过
        grid[i][j] = 2;
        //上 下 左 右
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new Number436().islandPerimeter(grid));
    }

}

