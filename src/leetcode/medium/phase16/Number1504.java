package leetcode.medium.phase16;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/22 10:31:52
 * 1504. 统计全 1 子矩形
 *
 * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *  
 *
 * 示例 1：
 *
 * 输入：mat = [[1,0,1],
 *             [1,1,0],
 *             [1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 * 示例 2：
 *
 * 输入：mat = [[0,1,1,0],
 *             [0,1,1,1],
 *             [1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * 示例 3：
 *
 * 输入：mat = [[1,1,1,1,1,1]]
 * 输出：21
 * 示例 4：
 *
 * 输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= rows <= 150
 * 1 <= columns <= 150
 * 0 <= mat[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-submatrices-with-all-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number1504 {

    public int numSubmat(int[][] mat) {
        int ans = 0;
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return ans;
        }

        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }

                int min = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    if (dp[k][j] == 0) {
                        break;
                    }
                    min = Math.min(min, dp[k][j]);
                    ans += min;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new Number1504().numSubmat(mat));
    }

}
