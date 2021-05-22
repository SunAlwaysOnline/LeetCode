package important.array;

/**
 * @author qcy
 * @create 2021/05/22 21:02:24
 * 连续子数组的最大和
 */
public class MaxSubSum {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

}
