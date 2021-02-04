package leetcode.medium.phase1;

import method.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/09/30 09:16:40
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
@SlidingWindow
public class Number3 {
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            set.clear();
            char start = s.charAt(i);
            set.add(start);
            for (int j = i + 1; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (!set.contains(temp)) {
                    set.add(temp);
                    max = Math.max(max, set.size());
                } else {
                    max = Math.max(max, set.size());
                    break;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < length; end++) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar) && (map.get(endChar) + 1) > start) {
                start = map.get(endChar) + 1;
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "au";
        int i = new Number3().lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
