package leetcode.medium.phase12;

import method.Classic;
import method.DP;
import method.StringOperation;

/**
 * @author qcy
 * @create 2021/03/09 14:29:15
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
@DP
public class Number1143 {


    //例如：s1="abcde"　　s2= "ace"，求两个字符串的公共子序列，答案是“ace”
    //
    //1.　S{s1,s2,s3....si} T{t1,t2,t3,t4....tj}
    //
    //2.　子问题划分
    //
    //(1) 如果S的最后一位等于T的最后一位，则最大子序列就是{s1,s2,s3...si-1}和{t1,t2,t3...tj-1}的最大子序列+1
    //
    //(2) 如果S的最后一位不等于T的最后一位，那么最大子序列就是
    //
    //① {s1,s2,s3..si}和 {t1,t2,t3...tj-1} 最大子序列
    //
    //② {s1,s2,s3...si-1}和{t1,t2,t3....tj} 最大子序列
    //
    //以上两个自序列的最大值
    //
    //3.　边界
    //
    //只剩下{s1}和{t1}，如果相等就返回1，不等就返回0
    //
    //4.　使用一个表格来存储dp的结果
    //
    //如果 S[i] == T[j] 则dp[i][j] = dp[i-1][j-1] + 1
    //
    //否则dp[i][j] = max(dp[i][j-1],dp[i-1][j])
    //
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Number1143().longestCommonSubsequence("abcde", "ace"));
    }

}
