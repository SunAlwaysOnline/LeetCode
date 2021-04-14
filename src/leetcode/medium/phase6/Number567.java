package leetcode.medium.phase6;

import method.Optimal;
import method.Violence;
import result.OverTime;

/**
 * @author qcy
 * @create 2021/04/14 16:14:53
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 提示：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number567 {

    boolean[] used;
    boolean flag = false;

    @OverTime
    @Violence
    public boolean checkInclusion1(String s1, String s2) {
        int length = s1.length();
        used = new boolean[length];
        dfs(new StringBuilder(), s1, s2);
        return flag;
    }

    private void dfs(StringBuilder sb, String s1, String s2) {
        if (flag) {
            return;
        }
        if (sb.length() == s1.length()) {
            if (s2.contains(sb.toString())) {
                flag = true;
                return;
            }
            return;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(s1.charAt(i));
            dfs(sb, s1, s2);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Optimal
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }

        int[] mt = new int[26];
        int[] nt = new int[26];

        for (int i = 0; i < m; i++) {
            mt[s1.charAt(i) - 'a']++;
            nt[s2.charAt(i) - 'a']++;
        }
        if (match(mt, nt)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            nt[s2.charAt(i) - 'a']++;
            nt[s2.charAt(i - m) - 'a']--;
            if (match(mt, nt)) {
                return true;
            }
        }

        return false;
    }

    public boolean match(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number567().checkInclusion("ab", "eidabo"));
    }

}
