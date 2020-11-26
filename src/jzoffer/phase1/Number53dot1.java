package jzoffer.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.BinarySearch;
import method.Optimal;
import method.Orignal;
import method.Violence;

/**
 * @author qcy
 * @create 2020/11/26 10:32:13
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 */
public class Number53dot1 {

    @Orignal
    @Violence
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int num : nums) {
            if (num == target) {
                res++;
                continue;
            }
            if (num > target) {
                return res;
            }
        }
        return res;
    }


    int res = 0;

    @Optimal
    @BinarySearch
    @SpaceComplexity("O(logn)")
    @TimeComplexity("O(1)")
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        search(nums, target, 0, length - 1);
        return res;
    }

    private void search(int nums[], int target, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            res++;
            search(nums, target, left, mid - 1);
            search(nums, target, mid + 1, right);
            return;
        }
        if (nums[mid] > target) {
            search(nums, target, left, mid - 1);
            return;
        }
        search(nums, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Number53dot1().search(nums, 8));
    }

}
