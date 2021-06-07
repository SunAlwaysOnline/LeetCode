package important.string;

/**
 * @author qcy
 * @create 2021/05/24 14:50:13
 * 最长回文子串
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromeSubStr {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }

        int length = s.length();
        //dp[i][j]=true代表[i,j]上的子串为回文子串
        boolean[][] dp = new boolean[length][length];

        int start = 0;
        int stop = 0;
        int maxLength = 0;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                //当两端点相等，但长度不超过3时,该子串为回文子串
                //当两端点相等，除去两端点的子串为回文子串时,该子串为回文子串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        start = i;
                        stop = j;
                    }
                }
            }
        }

        return s.substring(start, stop + 1);
    }

    public static void main(String[] args) {
        String result = new LongestPalindromeSubStr().longestPalindrome("babad");
        System.out.println(result);
    }
}
