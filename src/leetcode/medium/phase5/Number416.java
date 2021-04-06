package leetcode.medium.phase5;

import datastructure.Array;
import method.Classic;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/04/06 17:12:22
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number416 {
    boolean[] used;
    int length;
    boolean flag = false;
    int[] nums;

    @OverTime
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;
        length = nums.length;
        used = new boolean[length];
        this.nums = nums;

        dfs(half);

        return flag;
    }

    private void dfs(int target) {
        if (target == 0 || flag) {
            flag = true;
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            int leave = target - nums[i];
            if (leave < 0) {
                continue;
            }
            used[i] = true;
            dfs(leave);
            used[i] = false;
        }
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;
        int length = nums.length;
        boolean[][] dp = new boolean[length][half + 1];

        if (nums[0] < half) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= half; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length - 1][half];
    }


    public static void main(String[] args) {
        System.out.println(new Number416().canPartition(new int[]{1, 5, 11, 5}));
    }

}
