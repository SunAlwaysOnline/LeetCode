package jzoffer.phase1;

import method.DP;

/**
 * @author qcy
 * @create 2020/12/08 10:35:46
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 */
public class Number10dot1 {

    @DP
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] % 1000000007 + array[i - 2] % 1000000007;
            array[i] = array[i] % 1000000007;
        }

        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number10dot1().fib(3));
    }


}
