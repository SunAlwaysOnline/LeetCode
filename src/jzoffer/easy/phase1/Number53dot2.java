package jzoffer.easy.phase1;

import complexity.TimeComplexity;
import datastructure.Array;
import method.BinarySearch;
import method.BitOperation;
import method.Classic;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/01/19 14:02:55
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 */
@Classic
@Array
public class Number53dot2 {

    @BitOperation
    @TimeComplexity("O(n)")
    public int missingNumber1(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res ^ length;
    }

    @BinarySearch
    @Optimal
    @TimeComplexity("O(logn)")
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Number53dot2().missingNumber(nums));
    }

}
