package leetcode.medium.phase4;

import method.Classic;
import method.Optimal;
import method.Violence;
import result.OverTime;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/02/26 10:12:23
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number322 {

    int[] coins;
    int min;

    @Violence
    @OverTime
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        min = Integer.MAX_VALUE;

        dfs(amount, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private void dfs(int target, int count) {
        if (target == 0) {
            min = Math.min(min, count);
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (target < coins[i]) {
                continue;
            }
            dfs(target - coins[i], count + 1);
        }
    }

    @Optimal
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示凑出i的最小张数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Number322().coinChange(new int[]{1, 2, 5}, 11));
    }

}
