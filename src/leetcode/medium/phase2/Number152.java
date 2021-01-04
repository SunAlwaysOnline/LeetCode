package leetcode.medium.phase2;

import method.Classic;

/**
 * @author qcy
 * @create 2021/01/04 11:11:24
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
@Classic
public class Number152 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int res = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];

        for (int i = 1; i < length; i++) {
            int curMax;
            int curMin;
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new Number152().maxProduct(nums));
    }
}
