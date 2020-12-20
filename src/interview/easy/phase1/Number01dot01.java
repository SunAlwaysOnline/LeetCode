package interview.easy.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.BitOperation;
import method.Optimal;
import method.Orignal;
import method.Violence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/11/19 11:18:35
 * 面试题 01.01. 判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 */
public class Number01dot01 {


    @method.Set
    @Orignal
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public boolean isUnique1(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    @Violence
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    public boolean isUnique2(String astr) {
        char[] array = astr.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Optimal
    @BitOperation
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public boolean isUnique(String astr) {
        int temp = 0;
        for (char c : astr.toCharArray()) {
            int distance = c - 'a';
            if ((temp & (1 << distance)) != 0) {
                return false;
            }
            temp = temp | (1 << distance);
        }
        return true;
    }


    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(new Number01dot01().isUnique(a));
    }
}
