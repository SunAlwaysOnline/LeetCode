package leetcode.medium.phase14;

import datastructure.Grid;
import method.WaitForComplete;
import util.ArrayUtil;

/**
 * @author qcy
 * @create 2021/02/03 11:10:53
 */
@Grid
@WaitForComplete
public class Number1329 {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int min = Math.min(row, col);


        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        new Number1329().diagonalSort(mat);
        ArrayUtil.print(mat);
    }

}
