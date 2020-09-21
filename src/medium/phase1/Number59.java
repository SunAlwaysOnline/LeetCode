package medium.phase1;

/**
 * @author qcy
 * @create 2020/09/21 18:53:29
 * 59. 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Number59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int start = 1;
        int end = n * n;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (start <= end) {
            //从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = start++;
            }
            top++;

            //从上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = start++;
            }
            right--;

            //从右到左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = start++;
            }
            bottom--;

            //从下到上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = start++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new Number59().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
