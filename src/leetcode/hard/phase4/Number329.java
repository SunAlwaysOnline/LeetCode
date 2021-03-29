package leetcode.hard.phase4;

import method.Classic;
import method.Violence;
import method.WaitForOptimize;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/03/29 17:24:48
 */
@Classic
@WaitForOptimize
public class Number329 {

    int max = 1;
    int[][] matrix;
    int row;
    int col;
    boolean[][] used;

    @Violence
    @OverTime
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        used = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(-1, i, j, 0);
                used[i][j] = false;
            }
        }

        return max;
    }

    private void dfs(int pre, int i, int j, int curLength) {
        //越界
        if (i == row || i == -1 || j == col || j == -1) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        if (pre == -1 || matrix[i][j] > pre) {
            curLength++;
            max = Math.max(max, curLength);
        } else {
            return;
        }
        used[i][j] = true;
        dfs(matrix[i][j], i - 1, j, curLength);
        reCall(i - 1, j);
        dfs(matrix[i][j], i + 1, j, curLength);
        reCall(i + 1, j);
        dfs(matrix[i][j], i, j - 1, curLength);
        reCall(i, j - 1);
        dfs(matrix[i][j], i, j + 1, curLength);
        reCall(i, j + 1);
    }

    private void reCall(int i, int j) {
        if (i == -1 || i == row || j == -1 || j == col) {
            return;
        }
        used[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1}

                //                {3, 4, 5},
                //                {10, 11, 6},
                //                {9, 8, 7}
        };
        System.out.println(new Number329().longestIncreasingPath(matrix));
    }

}
