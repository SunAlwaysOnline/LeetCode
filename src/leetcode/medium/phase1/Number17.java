package leetcode.medium.phase1;

import method.Classic;
import method.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/25 13:56:51
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number17 {

    List<String> list;
    String digits;
    String[] array;

    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        array = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        this.digits = digits;
        dfs(new StringBuilder(""), 0);
        return list;
    }

    private void dfs(StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String s = array[digits.charAt(index) - '2'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        for (String s : new Number17().letterCombinations("23")) {
            System.out.println(s);
        }
    }

}
