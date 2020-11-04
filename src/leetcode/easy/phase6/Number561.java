package leetcode.easy.phase6;

import method.Maths;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/10/28 15:19:31
 *
 * 561. 数组拆分 I
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 */
public class Number561 {

    @Maths
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            result += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new Number561().arrayPairSum(nums));
    }
}
