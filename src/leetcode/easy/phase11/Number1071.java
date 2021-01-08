package leetcode.easy.phase11;

import method.Classic;
import method.Maths;
import method.Optimal;
import method.Violence;

/**
 * @author qcy
 * @create 2021/01/08 17:03:56
 * 1071. 字符串的最大公因子
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 *
 */
@Classic
@Maths
public class Number1071 {

    @Violence
    public String gcdOfStrings1(String str1, String str2) {
        String s = str1.length() > str2.length() ? str2 : str1;
        for (int i = s.length(); i > 0; i--) {
            String substring = s.substring(0, i);
            boolean a = str1.replaceAll(substring, "").equals("");
            boolean b = str2.replaceAll(substring, "").equals("");
            if (a && b) {
                return substring;
            }
        }
        return "";
    }

    @Optimal
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Number1071().gcdOfStrings("abab", "ababab"));
    }

}
