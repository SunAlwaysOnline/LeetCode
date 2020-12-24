package leetcode.easy.phase17;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DoublePointer;

/**
 * @author qcy
 * @create 2020/12/24 16:26:43
 * 1662. 检查两个字符串数组是否相等
 *
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 *
 */
public class Number1662 {

    @DoublePointer
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(m+n)")
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int length1 = word1.length;
        int length2 = word2.length;

        int index1 = 0;
        int indexChar1 = 0;
        int index2 = 0;
        int indexChar2 = 0;

        while (true) {
            if (indexChar1 == word1[index1].length()) {
                index1++;
                indexChar1 = 0;
            }
            if (indexChar2 == word2[index2].length()) {
                index2++;
                indexChar2 = 0;
            }

            if (index1 == length1 || index2 == length2) {
                break;
            }

            if (word1[index1].charAt(indexChar1) != word2[index2].charAt(indexChar2)) {
                return false;
            }
            indexChar1++;
            indexChar2++;
        }

        if (index1 == length1) {
            if (index2 != length2) {
                return false;
            }
        }

        return index1 == length1;
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "bc", "d", "e"};
        String[] word2 = {"abcde"};
        System.out.println(new Number1662().arrayStringsAreEqual(word1, word2));
    }

}
