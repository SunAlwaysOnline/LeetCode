package leetcode.easy.phase2;

import method.Violence;

/**
 * @author qcy
 * @create 2020/10/16 15:37:22
 */
public class Number121 {

    @Violence
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    result = Math.max(result, prices[j] - prices[i]);
                }
            }
        }

        return result;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int result = 0;
        int minBuyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minBuyPrice);
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Number121().maxProfit(prices));
    }
}
