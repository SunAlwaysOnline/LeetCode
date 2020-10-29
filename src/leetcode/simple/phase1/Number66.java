package leetcode.simple.phase1;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/10/29 19:37:00
 *
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Number66 {

    public int[] plusOne(int[] digits) {
        int[] array = new int[digits.length + 1];

        boolean isCarry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if ((digits[i] == 9 && isCarry) || (digits[i] == 9 && i == digits.length - 1)) {
                array[i + 1] = 0;
                isCarry = true;
            } else if (isCarry || i == digits.length - 1) {
                array[i + 1] = digits[i] + 1;
                isCarry = false;
            } else {
                array[i + 1] = digits[i];
            }
        }

        if (isCarry) {
            array[0] = 1;
            return array;
        }

        return Arrays.copyOfRange(array, 1, array.length);
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        Arrays.stream(new Number66().plusOne(digits)).forEach(System.out::println);
    }
}
