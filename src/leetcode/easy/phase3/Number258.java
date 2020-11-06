package leetcode.easy.phase3;

import method.Iteration;
import method.Maths;
import method.Orignal;
import method.Recursion;

/**
 * @author qcy
 * @create 2020/11/06 15:10:17
 * 258. 各位相加
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 */
public class Number258 {

    @Orignal
    @Iteration
    public int addDigits1(int num) {
        while (num >= 10) {
            int n = 0;
            while (num != 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }

    @Recursion
    public int addDigits2(int num) {
        if (num < 10) {
            return num;
        }

        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return addDigits2(res);
    }

    @Maths
    //https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Number258().addDigits(38));
    }

}
