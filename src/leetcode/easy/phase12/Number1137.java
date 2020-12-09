package leetcode.easy.phase12;

import method.DP;

/**
 * @author qcy
 * @create 2020/12/09 16:27:13
 * 1137. 第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *  
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 */
public class Number1137 {

    @DP
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int array[] = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }

        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number1137().tribonacci(25));
    }

}
