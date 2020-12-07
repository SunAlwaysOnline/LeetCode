package jzoffer.phase1;

/**
 * @author qcy
 * @create 2020/12/07 16:40:08
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 */
public class Number10dot2 {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] % 1000000007 + array[i - 2] % 1000000007;
            array[i] = array[i] % 1000000007;
        }

        return array[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Number10dot2().numWays(n));
    }

}
