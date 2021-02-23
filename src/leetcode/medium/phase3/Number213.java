package leetcode.medium.phase3;

import datastructure.Array;
import method.Classic;
import method.DP;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/02/23 09:36:29
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@DP
public class Number213 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int m = dp(Arrays.copyOfRange(nums, 1, length));
        int n = dp(Arrays.copyOfRange(nums, 0, length - 1));
        return Math.max(m, n);
    }

    private int dp(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }

    private int dp0(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(cur, pre + num);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {2, 23, 9, 3, 20};
        System.out.println(new Number213().rob(nums));
    }

}
