package leetcode.simple.phase15;

import method.BitOperation;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/11/02 09:24:21
 * 1470. 重新排列数组
 * <p>
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class Number1470 {

    //O(n)
    public int[] shuffle1(int[] nums, int n) {
        int[] result = new int[nums.length];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }

        return result;
    }

    //O(1)
    @BitOperation
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            //新下标
            int newIndex = i < n ? 2 * i : 2 * (i - n) + 1;
            //将原来元素的低十位存入新位置元素的高十位中
            nums[newIndex] |= (nums[i] & 1023) << 10;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] >> 10;
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        //1, 4, 2, 5, 3, 6
        Arrays.stream(new Number1470().shuffle(nums, 3)).forEach(System.out::println);
    }

}
