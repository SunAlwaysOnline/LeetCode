package important.array;

/**
 * @author qcy
 * @create 2021/06/15 16:00:28
 * 顺时针打印矩阵
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] ans = new int[row * col];
        int index = 0;

        int up = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[up][i];
            }
            up++;
            if (up > bottom) {
                break;
            }

            for (int i = up; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                ans[index++] = matrix[bottom][i];
            }
            bottom--;
            if (bottom < up) {
                break;
            }

            for (int i = bottom; i >= up; i--) {
                ans[index++] = matrix[i][left];
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        for (int i : new SpiralOrder().spiralOrder(matrix)) {
            System.out.println(i);
        }
    }
}
