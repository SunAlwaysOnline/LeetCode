package important.array;

/**
 * @author qcy
 * @create 2021/06/07 10:52:39
 * 买卖股票(一次)
 */
public class BuyAndSellSharesOnce {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int result = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(result, prices[i] - minPrice);
        }

        return result;
    }

}
