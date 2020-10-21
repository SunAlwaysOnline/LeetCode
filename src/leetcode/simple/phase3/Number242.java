package leetcode.simple.phase3;

import method.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/10/21 15:19:04
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class Number242 {

    @Sort
    public boolean isAnagram1(String s, String t) {
        if (s == null & t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    @method.Map
    public boolean isAnagram(String s, String t) {
        if (s == null & t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char sc : s.toCharArray()) {
            map.put(sc, map.getOrDefault(sc, 0) + 1);
        }

        for (char tc : t.toCharArray()) {
            Integer count = map.get(tc);
            if (count == null || count == 0) {
                return false;
            }
            map.put(tc, count - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "abcdabc";
        String t = "dcbaacb";
        System.out.println(new Number242().isAnagram(s, t));
    }
}
