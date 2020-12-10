package leetcode.easy.phase4;

import method.InterestingIdea;
import method.Orignal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/12/10 11:01:49
 * 389. 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 */
public class Number389 {

    @Orignal
    public char findTheDifference1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char sChar : s.toCharArray()) {
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
        }

        for (char tChar : t.toCharArray()) {
            if (!map.containsKey(tChar)) {
                return tChar;
            }
            int count = map.get(tChar) - 1;
            if (count == -1) {
                return tChar;
            }
            map.put(tChar, count);
        }

        return ' ';
    }

    @InterestingIdea
    public char findTheDifference(String s, String t) {
        return (char) (sum(t) - sum(s));
    }

    private int sum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "sbn";
        String t = "bnss";
        System.out.println(new Number389().findTheDifference(s, t));
    }

}
