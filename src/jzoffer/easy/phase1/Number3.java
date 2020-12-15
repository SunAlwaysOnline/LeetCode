package jzoffer.easy.phase1;

import method.Optimal;
import method.Orignal;
import method.Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/11/09 16:45:05
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 */
public class Number3 {

    @Orignal
    @method.Set
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    @Orignal
    @Sort
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                return pre;
            }
            pre = nums[i];
        }
        return -1;
    }

    @Optimal
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 3};
        new Number3().findRepeatNumber(nums);
    }

}
