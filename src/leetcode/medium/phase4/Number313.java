package leetcode.medium.phase4;

import method.Classic;
import method.DP;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/04/22 14:27:12
 * 313. 超级丑数
 *
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number313 {

    @DP
    public int nthSuperUglyNumber(int n, int[] primes) {
        int pLength = primes.length;
        if (pLength == 0 || n == 0) {
            return 1;
        }

        int[] indexArray = new int[pLength];
        Arrays.fill(indexArray, 1);

        int[] dp = new int[n + 1];
        dp[1] = 1;


        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[indexArray[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * dp[indexArray[j]]) {
                    indexArray[j]++;
                }
            }
            dp[i + 1] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number313().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

}
