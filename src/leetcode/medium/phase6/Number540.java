package leetcode.medium.phase6;

import complexity.TimeComplexity;
import datastructure.Array;
import method.BinarySearch;
import method.BitOperation;
import method.Classic;
import method.Orignal;

/**
 * @author qcy
 * @create 2021/01/13 13:51:04
 * 540. 有序数组中的单一元素
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 */
@Classic
@Array
public class Number540 {

    @Orignal
    @BitOperation
    @TimeComplexity("O(n)")
    public int singleNonDuplicate1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    @TimeComplexity("O(n)")
    public int singleNonDuplicate2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 2; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    @BinarySearch
    @TimeComplexity("O(logn)")
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if ((middle & 1) == 1) {
                middle--;
            }
            if (nums[middle] == nums[middle + 1]) {
                left = middle + 2;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 4};
        System.out.println(new Number540().singleNonDuplicate(nums));
    }

}
