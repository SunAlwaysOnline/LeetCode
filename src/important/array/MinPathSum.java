package important.array;

/**
 * @author qcy
 * @create 2021/06/12 23:08:12
 * 最小路径和
 * <p>
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row - 1][col - 1];
    }

}
