package leetcode.easy.phase2;

import method.BitOperation;

/**
 * @author qcy
 * @create 2020/10/02 16:40:43
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 */
public class Number191{

    //利用掩码按位与
    @BitOperation
    public int hammingWeight1(int n) {
        int sum = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            mask = mask << 1;
        }

        return sum;
    }

    //利用n&(n-1)将最后一个的1位变为0
    @BitOperation
    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Number191().hammingWeight(n));
    }
}
