package jzoffer.medium.phase1;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/07 09:13:01
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number12 {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = dfs(board, i, j, 0, word);
                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (board[i][j] == '.') {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';

        //利用||提前终止的特性，找到一种方案后，立即停止dfs
        boolean ans = dfs(board, i - 1, j, index + 1, word) ||
                dfs(board, i + 1, j, index + 1, word) ||
                dfs(board, i, j - 1, index + 1, word) ||
                dfs(board, i, j + 1, index + 1, word);
        board[i][j] = temp;

        return ans;
    }

    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean a = new Number12().exist(board, "ABCESEEEFS");
        System.out.println(a);
    }

}
