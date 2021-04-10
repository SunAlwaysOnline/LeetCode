package leetcode.medium.phase3;

import method.Classic;
import method.DP;
import method.Optimal;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/04/10 17:32:44
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 *
 * 1 <= n <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number279 {

    int min;

    @OverTime
    public int numSquares1(int n) {
        min = n;
        dfs(n, 0, n);
        return min;
    }

    private void dfs(int target, int count, int n) {
        if (target == 0) {
            min = Math.min(min, count);
            return;
        }
        for (int i = (int) (Math.sqrt(n) + 1); i >= 1; i--) {
            if (target - i * i < 0) {
                continue;
            }
            dfs(target - i * i, count + 1, n);
        }
    }

    @DP
    @Optimal
    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number279().numSquares(12));
    }

}
