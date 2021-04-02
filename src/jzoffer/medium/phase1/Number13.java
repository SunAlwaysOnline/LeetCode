package jzoffer.medium.phase1;

import datastructure.Grid;
import method.Classic;
import method.DFS;

/**
 * @author qcy
 * @create 2021/04/02 15:43:13
 * 剑指 Offer 13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number13 {
    int m;
    int n;
    int k;
    boolean[][] used;
    int count = 0;

    @DFS
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        used = new boolean[m][n];

        dfs(0, 0);

        return count;
    }


    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        if (!canWalk(i, j)) {
            return;
        }
        used[i][j] = true;
        count++;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    private boolean canWalk(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum = sum + i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum = sum + j % 10;
            j /= 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        System.out.println(new Number13().movingCount(16, 8, 4));
    }

}
