package leetcode.medium.phase5;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.DFS;
import method.PermutationAndCombination;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/04/10 17:59:37
 * 494. 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number494 {

    int count = 0;

    @OverTime
    @DFS
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(2^n)")
    public int findTargetSumWays1(int[] nums, int S) {
        dfs(nums, 0, S);
        return count;
    }

    private void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
                return;
            }
            return;
        }
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }

        return subSet(nums, (sum + S) / 2);
    }

    //计算nums中有多少个子集的和为target
    private int subSet(int[] nums, int target) {
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    //装不下的时候
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(new Number494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
