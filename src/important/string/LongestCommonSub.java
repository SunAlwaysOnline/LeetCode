package important.string;

/**
 * @author qcy
 * @create 2021/05/27 14:22:06
 * 最长公共子序列
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 */
public class LongestCommonSub {

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

        //dp[i][j]表示text1中前i个字符与test2中前j个字符的最大公共子串的长度
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
