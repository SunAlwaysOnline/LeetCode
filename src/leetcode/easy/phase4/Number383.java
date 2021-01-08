package leetcode.easy.phase4;

/**
 * @author qcy
 * @create 2021/01/08 09:23:39
 * 383. 赎金信
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *  
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class Number383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];

        for (char ch : magazine.toCharArray()) {
            array[ch - 'a'] += 1;
        }

        for (char ch : ransomNote.toCharArray()) {
            array[ch - 'a'] -= 1;
            if (array[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number383().canConstruct("bba", "ab"));
    }

}
