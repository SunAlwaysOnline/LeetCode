package jzoffer.easy.phase1;

import datastructure.Array;
import method.BitOperation;
import method.Classic;
import method.DoublePointer;

/**
 * @author qcy
 * @create 2021/01/11 17:10:57
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 */
@Classic
@Array
public class Number21 {

    @BitOperation
    @DoublePointer
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left < right) {
            //从左到右找到偶数
            while ((left < length && (nums[left] & 1) == 1)) {
                left++;
            }
            //从右到左找奇数
            while (right >= 0 && ((nums[right] & 1) == 0)) {
                right--;
            }
            if (left < right) {
                //交换两个数
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};
        for (int i : new Number21().exchange(nums)) {
            System.out.println(i);
        }
    }

}
