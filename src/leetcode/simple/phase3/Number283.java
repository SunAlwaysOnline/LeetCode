package leetcode.simple.phase3;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/10/13 17:03:14
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class Number283 {

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }

        for (int i = start; i < length; i++) {
            nums[i] = 0;
        }
    }

    //参照快排的思想
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Number283().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
