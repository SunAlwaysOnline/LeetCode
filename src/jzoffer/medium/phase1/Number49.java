package jzoffer.medium.phase1;

import method.Classic;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/04/15 13:41:01
 * 剑指 Offer 49. 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number49 {

    @Optimal
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            int min = Math.min(num2, Math.min(num3, num5));
            dp[i] = min;
            if (min == num2) {
                p2++;
            }
            if (min == num3) {
                p3++;
            }
            if (min == num5) {
                p5++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Number49().nthUglyNumber(10));
    }

}
