package interview.medium.phase8;

import method.Classic;
import method.PermutationAndCombination;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/02/07 15:18:56
 * 面试题 08.08. 有重复字符串的排列组合
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number08dot08 {

    Set<String> set = new HashSet<>();
    char[] chars;
    int length;
    boolean[] isUsed;

    public String[] permutation(String S) {
        chars = S.toCharArray();
        length = S.length();
        isUsed = new boolean[length];
        dfs(new StringBuilder());
        return set.toArray(new String[0]);
    }

    private void dfs(StringBuilder sb) {
        if (sb.length() == length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < length; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            char ch = chars[i];
            sb.append(ch);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        for (String s1 : new Number08dot08().permutation(s)) {
            System.out.println(s1);
        }
    }

}
