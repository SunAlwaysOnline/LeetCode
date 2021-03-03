package leetcode.medium.phase8;

import method.Classic;
import method.DP;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/03/03 15:01:29
 * 714. 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@DP
public class Number714 {

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];

        //第一维表示第几天，从0开始
        //第二维表示是否持有，0不持有，1持有
        //dp[i][]表示到第i天时，持有或者不持有的最大的收益
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }

    @Optimal
    public int maxProfit1(int[] prices, int fee) {
        int length = prices.length;


        //第一维表示第几天，从0开始
        //第二维表示是否持有，0不持有，1持有
        //dp[i][]表示到第i天时，持有或者不持有的最大的收益
        int noHave = 0;
        int have = -prices[0];

        for (int i = 1; i < length; i++) {
            noHave = Math.max(noHave, have + prices[i] - fee);
            have = Math.max(have, noHave - prices[i]);
        }

        return noHave;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new Number714().maxProfit(prices, 2));
    }

}
