package leetcode.hard.phase4;

import method.*;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/03/29 17:24:48
 * 329. 矩阵中的最长递增路径
 *
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 *
 * 输入：matrix = [[1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number329 {

    int max1 = 1;
    int[][] matrix1;
    int row1;
    int col1;
    boolean[][] used1;

    @Violence
    @OverTime
    public int longestIncreasingPath1(int[][] matrix) {
        this.matrix1 = matrix;
        row1 = matrix.length;
        col1 = matrix[0].length;
        used1 = new boolean[row1][col1];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                dfs(-1, i, j, 0);
                used1[i][j] = false;
            }
        }

        return max1;
    }

    private void dfs(int pre, int i, int j, int curLength) {
        //越界
        if (i == row1 || i == -1 || j == col1 || j == -1) {
            return;
        }
        if (used1[i][j]) {
            return;
        }
        if (pre == -1 || matrix1[i][j] > pre) {
            curLength++;
            max1 = Math.max(max1, curLength);
        } else {
            return;
        }
        used1[i][j] = true;
        dfs(matrix1[i][j], i - 1, j, curLength);
        reCall(i - 1, j);
        dfs(matrix1[i][j], i + 1, j, curLength);
        reCall(i + 1, j);
        dfs(matrix1[i][j], i, j - 1, curLength);
        reCall(i, j - 1);
        dfs(matrix1[i][j], i, j + 1, curLength);
        reCall(i, j + 1);
    }

    private void reCall(int i, int j) {
        if (i == -1 || i == row1 || j == -1 || j == col1) {
            return;
        }
        used1[i][j] = false;
    }

    //-------------------------------
    int[][] matrix;
    int row;
    int col;
    int[][] dp;
    int max = 0;

    @MemDP
    @Optimal
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                getLongPath(i, j);
            }
        }

        return max;
    }

    //以[i,j]开头的路径最长值
    private int getLongPath(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        //上
        int up = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            up += getLongPath(i - 1, j);
        }

        //下
        int bottom = 0;
        if (i + 1 < row && matrix[i + 1][j] > matrix[i][j]) {
            bottom += getLongPath(i + 1, j);
        }

        //左
        int left = 0;
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            left += getLongPath(i, j - 1);
        }

        //左
        int right = 0;
        if (j + 1 < col && matrix[i][j + 1] > matrix[i][j]) {
            right += getLongPath(i, j + 1);
        }

        int maxLength = Math.max(Math.max(up, bottom), Math.max(left, right)) + 1;
        max = Math.max(max, maxLength);
        dp[i][j] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(new Number329().longestIncreasingPath(matrix));
    }

}
