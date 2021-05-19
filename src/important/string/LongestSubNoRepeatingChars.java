package important.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/05/19 09:53:59
 * 无重复字符的最长子串
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubNoRepeatingChars {

    //类似于滑动窗口的思想
    public int lengthOfLongestSubstring(String s) {
        //记录访问过的字符
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            //abcba 当再次出现a时，start不可以回到1,而是不动,否则当前截取的子串为bcba,其中有重复字符b
            if (map.containsKey(curChar) && map.get(curChar) + 1 > start) {
                start = map.get(curChar) + 1;
            }
            max = Math.max(max, end - start + 1);
            map.put(curChar, end);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubNoRepeatingChars().lengthOfLongestSubstring("abcabcbb"));
    }
}
