package leetcode.easy.phase3;

import method.StringOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/01/27 09:19:01
 * 290. 单词规律
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@StringOperation
public class Number290 {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] splits = s.split(" ");
        if (chars.length != splits.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            String str = splits[i];
            String val = map.get(ch);
            if (val == null) {
                if (set.contains(str)) {
                    return false;
                }
                set.add(str);
                map.put(ch, str);
            } else {
                if (!str.equals(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number290().wordPattern("abba", "c d d c"));
    }

}
