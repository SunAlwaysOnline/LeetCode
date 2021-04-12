package leetcode.medium.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.Optimal;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/04/11 11:12:37
 * 264. 丑数 II
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 1690
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number264 {

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(nlogn)")
    public int nthUglyNumber1(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);

        Set<Long> set = new HashSet<>();
        while (true) {
            long poll = queue.poll();
            if (set.contains(poll)) {
                continue;
            }
            set.add(poll);
            n--;
            if (n == 0) {
                return (int) poll;
            }
            queue.offer(poll * 2);
            queue.offer(poll * 3);
            queue.offer(poll * 5);
        }
    }

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    @Optimal
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = 2 * dp[p2];
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];

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
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number264().nthUglyNumber(10));
    }

}
