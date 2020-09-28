package leetcode.medium.phase1;

/**
 * @author qcy
 * @create 2020/09/21 10:05:39
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 具体思路:https://blog.csdn.net/qq_33591903/article/details/82950798
 */
public class Number5 {

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int start = 0;
        int stop = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        start = i;
                        stop = j;
                    }
                }
            }
        }
        return s.substring(start, stop + 1);
    }

}
