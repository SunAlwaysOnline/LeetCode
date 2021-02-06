package leetcode.medium.phase9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/02/06 19:12:15
 * 890. 查找和替换模式
 *
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 * 
 *
 * 示例：
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@method.Map
public class Number890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        Map<Character, Character> wTop = new HashMap<>();
        Map<Character, Character> pToW = new HashMap<>();
        out:
        for (String word : words) {
            char[] wordCharArray = word.toCharArray();
            char[] patternCharArray = pattern.toCharArray();
            wTop.clear();
            pToW.clear();
            for (int i = 0; i < wordCharArray.length; i++) {
                char chW = wordCharArray[i];
                char chP = patternCharArray[i];
                if (!wTop.containsKey(chW)) {
                    if (pToW.containsKey(chP)) {
                        continue out;
                    }
                    wTop.put(chW, chP);
                    pToW.put(chP, chW);
                } else {
                    if (wTop.get(chW) != chP) {
                        continue out;
                    }
                }
            }
            list.add(word);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"aab", "wer", "ccc"};
        String pattern = "qqw";
        for (String s : new Number890().findAndReplacePattern(words, pattern)) {
            System.out.println(s);
        }
    }

}
