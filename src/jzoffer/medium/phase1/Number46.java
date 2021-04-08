package jzoffer.medium.phase1;

import complexity.SpaceComplexity;
import method.Classic;
import method.DP;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/04/08 14:07:11
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number46 {

    //输入: 12258
    //输出: 5
    //解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
    @DP
    @SpaceComplexity("O(n)")
    public int translateNum1(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        if (length == 1) {
            return 1;
        }
        //dp[i]表示x(1)x(2)...x(i-1)x(i)数字组成的方案数
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= length; i++) {
            int a = str.charAt(i - 2) - '0';
            int b = str.charAt(i - 1) - '0';
            int c = 10 * a + b;
            if (c >= 10 && c <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[length];
    }

    @Optimal
    @SpaceComplexity("O(1)")
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        if (length == 1) {
            return 1;
        }

        int prePre = 1;
        int pre = 1;

        for (int i = 2; i <= length; i++) {
            int a = str.charAt(i - 2) - '0';
            int b = str.charAt(i - 1) - '0';
            int c = 10 * a + b;
            int cur;
            if (c >= 10 && c <= 25) {
                cur = pre + prePre;
            } else {
                cur = pre;
            }
            prePre = pre;
            pre = cur;
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new Number46().translateNum(12258));
    }

}
