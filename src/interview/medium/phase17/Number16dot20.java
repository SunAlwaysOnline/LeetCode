package interview.medium.phase17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/02/07 10:16:31
 * 面试题 16.20. T9键盘
 *
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
 * 给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 *
 *
 * 示例 1:
 *
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 *
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 *
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/t9-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number16dot20 {

    Map<Character, String> map = new HashMap<>();

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> list = new ArrayList<>();
        init();
        char[] numCharArray = num.toCharArray();
        out:
        for (String word : words) {
            char[] wordCharArray = word.toCharArray();
            for (int i = 0; i < num.length(); i++) {
                if (!map.get(numCharArray[i]).contains(String.valueOf(wordCharArray[i]))) {
                    continue out;
                }
            }
            list.add(word);
        }
        return list;
    }

    private void init() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

}
