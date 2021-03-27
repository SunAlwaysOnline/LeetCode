package leetcode.hard.phase1;

import datastructure.Grid;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/27 19:15:14
 * 37. 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 * 一个数独。
 *
 *
 * 答案被标成红色。
 *
 * 提示：
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number37 {
    boolean[][] line = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    char[][] board;
    boolean complete;
    List<int[]> list;

    public void solveSudoku(char[][] board) {
        this.board = board;
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                    continue;
                }
                int num = board[i][j] - '0' - 1;
                line[i][num] = true;
                column[j][num] = true;
                block[i / 3][j / 3][num] = true;
            }
        }

        recursion(0);
    }

    private void recursion(int index) {
        if (index == list.size()) {
            complete = true;
            return;
        }

        int[] array = list.get(index);
        int i = array[0];
        int j = array[1];

        for (int digit = 0; digit < 9 && !complete; digit++) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                //当前数字合法
                line[i][digit] = true;
                column[j][digit] = true;
                block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);

                recursion(index + 1);
                line[i][digit] = false;
                column[j][digit] = false;
                block[i / 3][j / 3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Number37().solveSudoku(board);
        System.out.println(1);
    }

}
