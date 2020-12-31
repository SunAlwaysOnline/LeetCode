package interview.easy.phase1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/12/31 21:44:16
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 */
public class Number01dot02 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            Integer count = map.get(ch);
            if (count == 0) {
                return false;
            }
            map.put(ch, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcb";
        String s2 = "cbba";
        System.out.println(new Number01dot02().CheckPermutation(s1, s2));
    }

}
