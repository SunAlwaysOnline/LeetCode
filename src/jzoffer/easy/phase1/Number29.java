package jzoffer.easy.phase1;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/13 14:38:46
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 */
@Classic
@Grid
public class Number29 {

    //1  2  3
    //4  5  6
    //7  8  9
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int index = 0;
        //上下左右的边界
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int rigth = col - 1;

        while (true) {
            for (int i = left; i <= rigth; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][rigth];
            }
            if (--rigth < left) {
                break;
            }

            for (int i = rigth; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > rigth) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        for (int i : new Number29().spiralOrder(matrix)) {
            System.out.println(i);
        }
    }

}
