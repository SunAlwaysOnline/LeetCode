package leetcode.easy.phase4;

/**
 * @author qcy
 * @create 2020/09/27 15:16:09
 */
public class Number392 {
    //s: ace   t: babcde

    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a') p = i;
            }
        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String t = "abcde";
        String s = "ace";
        System.out.println(new Number392().isSubsequence2(s, t));
    }

}
