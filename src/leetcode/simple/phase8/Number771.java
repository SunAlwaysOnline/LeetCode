package leetcode.simple.phase8;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author qcy
 * @create 2020/10/02 11:43:04
 * 771. 宝石与石头
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 */
public class Number771 {

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) {
            return 0;
        }
        if (S == null || S.length() == 0) {
            return 0;
        }

        int sum = 0;
        int jLength = J.length();
        int sLength = S.length();

        for (int j = 0; j < jLength; j++) {
            char c = J.charAt(j);
            for (int s = 0; s < sLength; s++) {
                if (S.charAt(s) == c) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAb";
        System.out.println(new Number771().numJewelsInStones(j, s));
    }
}
