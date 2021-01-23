package leetcode.easy.phase8;

import method.Classic;
import method.Optimal;
import method.StringOperation;
import method.Violence;

import java.util.Objects;

/**
 * @author qcy
 * @create 2021/01/23 18:54:11
 * 796. 旋转字符串
 *
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 *
 * A 和 B 长度不超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number796 {

    @Violence
    public boolean rotateString1(String A, String B) {
        int lengthA = A.length();
        int lengthB = B.length();
        if (lengthA != lengthB) {
            return false;
        }
        if (Objects.equals(A, B)) {
            return true;
        }

        for (int i = 1; i < lengthA; i++) {
            String temp = A.substring(i) + A.substring(0, i);
            if (temp.equals(B)) {
                return true;
            }
        }
        return false;
    }

    @Optimal
    public boolean rotateString(String A, String B) {
        int lengthA = A.length();
        int lengthB = B.length();
        if (lengthA != lengthB) {
            return false;
        }
        return (A + A).contains(B);
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab";
        System.out.println(new Number796().rotateString(A, B));
    }

}
