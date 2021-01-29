package util;

/**
 * @author qcy
 * @create 2020/09/22 11:52:47
 */
public class ArrayUtil {
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
