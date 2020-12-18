package jzoffer.easy.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DoublePointer;
import method.Map;
import method.Optimal;
import result.OverTime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/11/11 13:49:39
 * 剑指 Offer 57. 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 */
public class Number57 {

    @OverTime
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n^2)")
    public int[] twoSum1(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                    return res;
                }
                if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        return new int[0];
    }

    @Map
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return new int[0];
    }

    @Optimal
    @DoublePointer
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            }
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(new Number57().twoSum1(nums, 5)).forEach(System.out::println);
    }

}
