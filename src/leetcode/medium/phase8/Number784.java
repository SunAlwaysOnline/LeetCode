package leetcode.medium.phase8;

import method.Classic;
import method.PermutationAndCombination;
import util.ListUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/04/28 14:08:13
 * 784. 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *  
 *
 * 提示：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number784 {

    boolean[] isNumArray;
    Set<String> set;

    public List<String> letterCasePermutation(String S) {
        int length = S.length();
        set = new HashSet<>();

        isNumArray = new boolean[length];
        for (int i = 0; i < length; i++) {
            isNumArray[i] = isNum(S.charAt(i));
        }

        dfs(S.toCharArray(), 0);

        return new ArrayList<>(set);
    }

    private void dfs(char[] chars, int i) {
        set.add(new String(chars));
        if (i == chars.length) {
            return;
        }
        char ch = chars[i];
        if (isNumArray[i]) {
            dfs(chars, i + 1);
        } else {
            dfs(chars, i + 1);
            if (isCap(ch)) {
                chars[i] = (char) (ch + 'a' - 'A');
                dfs(chars, i + 1);
            } else {
                chars[i] = (char) (ch + 'A' - 'a');
                dfs(chars, i + 1);
            }
            chars[i] = ch;
        }
    }

    //判断该字符是否是数字
    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    //判断该字符是否是大写
    private boolean isCap(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static void main(String[] args) {
        List<String> list = new Number784().letterCasePermutation("a1b2");
        ListUtil.print(list);
    }

}
