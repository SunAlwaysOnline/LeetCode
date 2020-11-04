package leetcode.easy.phase16;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/10/11 19:39:15
 * 1512. 好数对的数目
 *
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 */
public class Number1512 {

    public int numIdenticalPairs(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length == 0 || length == 1) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);
        int num = nums[0];
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] == num) {
                count++;
                if (i == length - 1) {
                    result += count * (count - 1) / 2;
                }
            } else {
                result += count * (count - 1) / 2;
                count = 1;
                num = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(new Number1512().numIdenticalPairs(nums));
    }
}

