package important.string;

/**
 * @author qcy
 * @create 2021/06/07 17:59:25
 * 最长公共子串
 */
public class LongestCommonSubStr {

    public String longestCommonSubStr(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        int aLength = a.length();
        int bLength = b.length();
        if (aLength == 0 || bLength == 0) {
            return "";
        }

        //dp[i][j]代表a中[0,i]与b中[0,j]的最长公共子串的长度
        int[][] dp = new int[aLength][bLength];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] >= maxLength) {
                        endIndex = j;
                        maxLength = dp[i][j];
                    }
                }
            }
        }

        return b.substring(endIndex - maxLength + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "bcd";
        System.out.println(new LongestCommonSubStr().longestCommonSubStr(a, b));
    }
}
