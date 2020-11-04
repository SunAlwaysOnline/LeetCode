package leetcode.easy.phase14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/10/29 09:22:54
 * 1380. 矩阵中的幸运数
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 *
 */
public class Number1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> lineMinSet = new HashSet<>();
        int[] columnMaxArray = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int lineMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                lineMin = Math.min(lineMin, matrix[i][j]);
                columnMaxArray[j] = Math.max(columnMaxArray[j], matrix[i][j]);
            }
            lineMinSet.add(lineMin);
        }

        for (int num : columnMaxArray) {
            if (lineMinSet.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        new Number1380().luckyNumbers(matrix).forEach(System.out::println);
    }

}
