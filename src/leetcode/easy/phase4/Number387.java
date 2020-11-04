package leetcode.easy.phase4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/10/21 15:37:34
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 */
public class Number387 {
    @method.Map
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "dddccdbba";
        System.out.println(new Number387().firstUniqChar(s));
    }
}
