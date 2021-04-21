package leetcode.medium.phase10;

import datastructure.Grid;
import method.BFS;
import method.Classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/04/21 16:56:14
 * 994. 腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
@BFS
public class Number994 {

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }
        if (queue.isEmpty()) {
            return -1;
        }

        int time = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] array = queue.poll();
                int m = array[0];
                int n = array[1];
                if (m - 1 >= 0 && m - 1 < grid.length && grid[m - 1][n] == 1) {
                    grid[m - 1][n] = 2;
                    fresh--;
                    queue.offer(new int[]{m - 1, n});
                }
                if (m + 1 >= 0 && m + 1 < grid.length && grid[m + 1][n] == 1) {
                    grid[m + 1][n] = 2;
                    fresh--;
                    queue.offer(new int[]{m + 1, n});
                }
                if (n - 1 >= 0 && n - 1 < grid[0].length && grid[m][n - 1] == 1) {
                    grid[m][n - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{m, n - 1});
                }
                if (n + 1 >= 0 && n + 1 < grid[0].length && grid[m][n + 1] == 1) {
                    grid[m][n + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{m, n + 1});
                }
            }
            time++;
        }

        if (fresh == 0) {
            return time;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new Number994().orangesRotting(grid));
    }

}
