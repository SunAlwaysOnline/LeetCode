package leetcode.easy.phase5;

import method.StringOperation;
import method.WaitForOptimize;

/**
 * @author qcy
 * @create 2021/01/14 09:25:00
 * 459. 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 */
@StringOperation
@WaitForOptimize
public class Number459 {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) {
                continue;
            }
            String subStr = s.substring(0, i);
            if (s.replaceAll(subStr, "").equals("")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Number459().repeatedSubstringPattern(s));
    }

}
