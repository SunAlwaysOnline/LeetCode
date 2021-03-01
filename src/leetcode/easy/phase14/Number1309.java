package leetcode.easy.phase14;

import method.Optimal;
import method.StringOperation;
import method.Violence;

/**
 * @author qcy
 * @create 2021/03/01 10:32:42
 * 1309. 解码字母到整数映射
 *
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 *
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 *
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 *
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@StringOperation
public class Number1309 {

    @Violence
    public String freqAlphabets1(String s) {
        for (int i = 10; i <= 26; i++) {
            String replace = i + "#";
            //a:97
            char ch = (char) (97 + i - 1);
            s = s.replaceAll(replace, ch + "");
        }
        for (int i = 0; i <= 9; i++) {
            char ch = (char) (97 + i - 1);
            s = s.replaceAll(i + "", ch + "");
        }
        return s;
    }

    @Optimal
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = s.length();
        while (i < length) {
            if (i < length - 2 && s.charAt(i + 2) == '#') {
                char ch = (char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1);
                sb.append(ch);
                i += 3;
            } else {
                char ch = (char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1);
                sb.append(ch);
                i += 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(new Number1309().freqAlphabets(s));
    }

}
