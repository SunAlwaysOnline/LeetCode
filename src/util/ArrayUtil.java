package util;

/**
 * @author qcy
 * @create 2020/09/22 11:52:47
 */
public class ArrayUtil {
    public static void print(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
