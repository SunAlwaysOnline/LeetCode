package leetcode.simple.phase9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/09/28 17:44:46
 * 884. 两句话中的不常见单词
 *
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * 返回所有不常用单词的列表。
 *
 * 您可以按任何顺序返回列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 *
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 *
 */
public class Number884 {

    //时间复杂度O(m+n),m为A的长度,n为B的长度
    //空间复杂度O(m+n)
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();

        for (String a : A.split(" ")) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (String b : B.split(" ")) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        return list.toArray(new String[0]);
    }

}
