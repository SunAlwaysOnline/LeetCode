package jzoffer.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.DP;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/01/02 22:33:24
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 10^5
 *
 *  
 *
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 */
@Classic
public class Number63 {

    @DP
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) {
            return 0;
        }

        int[] res = new int[prices.length];
        res[0] = 0;
        int min = prices[0];

        for (int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            res[i] = Math.max(res[i - 1], prices[i] - min);
        }

        return res[length - 1];
    }

    @DP
    @Optimal
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num : prices) {
            min = Math.min(num, min);
            res = Math.max(res, num - min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 3};
        System.out.println(new Number63().maxProfit(prices));
    }
}
