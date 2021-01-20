package interview.easy.phase16;

import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/20 09:36:05
 * 面试题 16.17. 连续数列
 *
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number16dot17 {

    @TimeComplexity("O(n)")
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Number16dot17().maxSubArray(nums));
    }

}
