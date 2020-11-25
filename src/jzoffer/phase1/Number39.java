package jzoffer.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Optimal;
import method.Orignal;
import method.Sort;
import method.Violence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/11/25 10:31:40
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 */
public class Number39 {

    @Orignal
    @Violence
    @method.Map
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    @Sort
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(nlogn)")
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    @Optimal
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int majorityElement(int[] nums) {
        int cur = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                cur = num;
            }
            vote += num == cur ? 1 : -1;
        }
        return cur;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Number39().majorityElement(nums));
    }

}
