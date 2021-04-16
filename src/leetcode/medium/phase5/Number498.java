package leetcode.medium.phase5;

import datastructure.Grid;
import method.Classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/16 09:15:06
 * 498. 对角线遍历
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 解释:
 *
 *
 * 说明:
 *
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row + col - 1;

        List<LinkedList<Integer>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new LinkedList<>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = i + j;
                LinkedList<Integer> list = lists.get(sum);
                if (sum % 2 == 0) {
                    list.addFirst(matrix[i][j]);
                } else {
                    list.add(matrix[i][j]);
                }
            }
        }

        int[] ans = new int[row * col];
        int index = 0;
        for (List<Integer> list : lists) {
            for (int num : list) {
                ans[index++] = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ints = new Number498().findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(ints));
    }

}
