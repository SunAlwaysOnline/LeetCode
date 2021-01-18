package leetcode.easy.phase12;

/**
 * @author qcy
 * @create 2021/01/18 17:47:17
 * 1119. 删去字符串中的元音
 *
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 * 
 *
 * 示例 1：
 *
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 *
 * 输入："aeiou"
 * 输出：""
 *  
 *
 * 提示：
 *
 * S 仅由小写英文字母组成。
 * 1 <= S.length <= 1000
 *
 */
public class Number1119 {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aodjaduasdmuies";
        System.out.println(new Number1119().removeVowels(s));
    }

}
