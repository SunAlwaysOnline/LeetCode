package interview.easy.phase8;

import method.Classic;
import method.DP;

/**
 * @author qcy
 * @create 2020/12/29 17:21:04
 * 面试题 08.01. 三步问题
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，
 * 计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 */
@Classic
public class Number08dot01 {

    @DP
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number08dot01().waysToStep(5));
    }

}
