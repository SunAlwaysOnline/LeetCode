package leetcode.easy.phase7;

/**
 * @author qcy
 * @create 2020/12/17 15:17:52
 * 628. 三个数的最大乘积
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 */
public class Number628 {

    public int maximumProduct(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }

            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }
        return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};
        System.out.println(new Number628().maximumProduct(nums));
    }

}
