package leetcode.medium.phase1;

import datastructure.Grid;
import method.Classic;
import method.DFS;

/**
 * @author qcy
 * @create 2021/04/04 19:28:35
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number79 {


    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == first) {
                    boolean ans = dfs(board, i, j, word, 0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @DFS
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (board[i][j] == '.') {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';

        boolean up = dfs(board, i - 1, j, word, index + 1);
        boolean bottom = dfs(board, i + 1, j, word, index + 1);
        boolean left = dfs(board, i, j - 1, word, index + 1);
        boolean right = dfs(board, i, j + 1, word, index + 1);
        boolean ans = up || bottom || left || right;

        board[i][j] = temp;
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean a = new Number79().exist(board, "ABCESEEEFS");
        System.out.println(a);
    }

}
