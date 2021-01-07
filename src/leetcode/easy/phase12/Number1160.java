package leetcode.easy.phase12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/07 17:40:14
 * 1160. 拼写单词
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 */
public class Number1160 {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = chars.toCharArray();
        for (char ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        out:
        for (String word : words) {
            char[] array = word.toCharArray();
            Map<Character, Integer> itemMap = new HashMap<>();
            for (char ch : array) {
                itemMap.put(ch, itemMap.getOrDefault(ch, 0) + 1);
            }

            for (char ch : array) {
                if (itemMap.getOrDefault(ch, 0) > map.getOrDefault(ch, 0)) {
                    continue out;
                }
            }

            count += word.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"ab", "abb", "b", "a"};
        System.out.println(new Number1160().countCharacters(words, "ab"));
    }

}
