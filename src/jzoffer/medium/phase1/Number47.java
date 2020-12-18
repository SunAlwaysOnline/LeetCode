package jzoffer.medium.phase1;

import method.DP;

/**
 * @author qcy
 * @create 2020/12/18 15:44:56
 * 剑指 Offer 47. 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 */
public class Number47 {

    @DP
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    //最上边
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    //最左边
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                //其他部分
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[row - 1][col - 1];
    }

}
