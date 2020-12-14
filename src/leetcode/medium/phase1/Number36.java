package leetcode.medium.phase1;

import method.Optimal;
import method.Orignal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/12/14 14:20:22
 * 36. 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 */
public class Number36 {

    @Orignal
    public boolean isValidSudoku1(char[][] board) {
        //验证横向与纵向是否重复
        for (int i = 0; i < 9; i++) {
            Set<Character> horizontalSet = new HashSet<>();
            Set<Character> verticalSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                if (c1 != '.') {

                    if (horizontalSet.contains(c1)) {
                        return false;
                    }
                    horizontalSet.add(c1);
                }

                char c2 = board[j][i];
                if (c2 != '.') {
                    if (verticalSet.contains(c2)) {
                        return false;
                    }
                    verticalSet.add(c2);
                }
            }
        }

        //验证每个宫
        for (int i = 1; i <= 7; i += 3) {
            for (int j = 1; j <= 7; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        char c = board[m][n];
                        if (c == '.') {
                            continue;
                        }
                        if (set.contains(c)) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }

    @Optimal
    public boolean isValidSudoku(char[][] board) {
        //一次遍历
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curChar = board[i][j];
                if (curChar == '.') {
                    continue;
                }

                int cur = curChar - '0';

                if (row[i][cur] == 1) {
                    return false;
                }
                if (col[j][cur] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][cur] == 1) {
                    return false;
                }

                row[i][cur] = 1;
                col[j][cur] = 1;
                box[j / 3 + (i / 3) * 3][cur] = 1;
            }
        }
        return true;
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
        System.out.println(new Number36().isValidSudoku(board));

    }
}
