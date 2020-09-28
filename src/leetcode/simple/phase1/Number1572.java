package leetcode.simple.phase1;

/**
 * @author qcy
 * @create 2020/09/22 11:14:37
 * 1572. 矩阵对角线元素的和
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Number1572 {

    public int diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int sum = 0;
        int length = mat.length;
        for (int i = 0; i < mat.length; i++) {
            //主对角线,例如(0,0)、（1,1）、（2,2）...(i,i)
            sum += mat[i][i];
            //副对角线,例如(0,length-1)、（1,length-2）、（2,length-3）...(i,0)
            sum += mat[i][length - i - 1];
        }

        //如果是奇数长度，则去掉重复计算的数，即数组中间的数
        if (length % 2 == 1) {
            sum -= mat[length / 2][length / 2];
        }

        return sum;
    }

}
