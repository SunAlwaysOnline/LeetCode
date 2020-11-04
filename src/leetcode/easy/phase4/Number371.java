package leetcode.easy.phase4;

import method.BitOperation;

/**
 * @author qcy
 * @create 2020/10/17 21:39:28
 * 371. 两整数之和
 *
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 */
public class Number371 {

    @BitOperation
    public int getSum(int a, int b) {
        while (true) {
            //计算低位
            int low = a ^ b;
            //计算进位
            int carry = a & b;

            //高位为0,则返回低位数字
            if (carry == 0) {
                return low;
            }

            a = low;
            b = carry << 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number371().getSum(15, 17));
    }
}
