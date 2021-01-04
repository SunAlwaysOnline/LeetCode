package leetcode.medium.phase2;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/04 21:43:45
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
@Classic
@Grid
public class Number130 {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //从边界的O开始
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        //此时围不住的O全变为A
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }

            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        //越界
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }
        //遍历过
        if (board[i][j] == 'A') {
            return;
        }
        board[i][j] = 'A';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}
