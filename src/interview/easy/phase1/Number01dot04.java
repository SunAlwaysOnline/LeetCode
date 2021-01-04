package interview.easy.phase1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/04 21:24:32
 * 面试题 01.04. 回文排列
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 */
public class Number01dot04 {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //奇数
        int evenCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                evenCount++;
            }
        }

        int length = s.length();
        if ((length & 1) == 0) {
            return evenCount == 0;
        }
        return evenCount == 1;

    }

    public static void main(String[] args) {
        String s = "tatc";
        System.out.println(new Number01dot04().canPermutePalindrome(s));
    }

}
