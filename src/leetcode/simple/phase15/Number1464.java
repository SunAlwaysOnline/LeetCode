package leetcode.simple.phase15;

/**
 * @author qcy
 * @create 2020/09/21 20:00:34
 * 1464. 数组中两元素的最大乘积
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 *
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 *
 * 输入：nums = [3,7]
 * 输出：12
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 *
 */
public class Number1464 {
    public int maxProduct(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        //最大的数
        int first = 0;
        //第二大的数
        int second = 0;

        for (int i : nums) {
            if (i >= first) {
                second = first;
                first = i;
            } else {
                if (i >= second) {
                    second = i;
                }
            }
        }
        return (first - 1) * (second - 1);
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 2, 1, 9};
        System.out.println(new Number1464().maxProduct(array));
    }
}
