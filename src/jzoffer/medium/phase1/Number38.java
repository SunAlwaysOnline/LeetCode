package jzoffer.medium.phase1;

import method.Classic;
import method.PermutationAndCombination;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/02/23 14:57:37
 * 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number38 {

    Set<String> set;
    int length;
    boolean[] useArray;
    String s;

    public String[] permutation(String s) {
        set = new HashSet<>();
        this.length = s.length();
        useArray = new boolean[length];
        this.s = s;

        create(new StringBuilder(""));

        return set.toArray(new String[0]);
    }

    private void create(StringBuilder sb) {
        if (sb.length() == length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < length; i++) {
            if (useArray[i]) {
                continue;
            }
            sb.append(s.charAt(i));
            useArray[i] = true;
            create(sb);
            useArray[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        for (String abc : new Number38().permutation("abc")) {
            System.out.println(abc);
        }
    }

}
