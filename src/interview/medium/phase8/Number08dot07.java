package interview.medium.phase8;

import method.Classic;
import method.PermutationAndCombination;

/**
 * @author qcy
 * @create 2021/01/27 16:22:10
 * 面试题 08.07. 无重复字符串的排列组合
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
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
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number08dot07 {

    String[] res;
    int resIndex;

    public String[] permutation(String S) {
        this.res = new String[size(S.length())];
        resIndex = 0;

        char[] chars = S.toCharArray();
        reCall(chars, new StringBuilder());

        return res;
    }

    private void reCall(char[] chars, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res[resIndex++] = sb.toString();
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (sb.indexOf(String.valueOf(chars[i])) != -1) {
                continue;
            }
            sb.append(chars[i]);
            reCall(chars, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private int size(int num) {
        int sum = 1;
        while (num != 0) {
            sum *= num;
            num--;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (String s : new Number08dot07().permutation("abc")) {
            System.out.println(s);
        }
    }
}
