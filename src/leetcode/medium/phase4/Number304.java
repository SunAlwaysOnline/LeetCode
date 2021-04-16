package leetcode.medium.phase4;

import datastructure.Grid;
import method.Classic;
import method.PrefixSum;

/**
 * @author qcy
 * @create 2021/03/02 09:40:02
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
@PrefixSum
public class Number304 {

    class NumMatrix {
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            sum = new int[row + 1][col + 1];

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int x1 = row1 + 1;
            int y1 = col1 + 1;
            int x2 = row2 + 1;
            int y2 = col2 + 1;
            return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
        }
    }

}
