package simple.phase2;

/**
 * @author qcy
 * @create 2020/09/21 20:00:34
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class Number53 {
    //暴力破解法，时间复杂度为O(n^3)
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    //暴力破解法改进，上一个方法存在重复计算，这一次我们用个变量暂存之前的运算结果，此时的时间复杂度可缩小为O(n^2)
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    //动态规划法，可将时间复杂度缩小到O(n)
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        int cur = nums[0];
        for (int i = 1; i < len; i++) {
            if (cur > 0) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return maxSum;
    }

}
