package interview.easy.phase1;

import method.Classic;
import method.StringOperation;
import method.Violence;

import java.util.Objects;

/**
 * @author qcy
 * @create 2021/02/25 14:49:19
 * 面试题 01.09. 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number01dot09 {

    @Violence
    public boolean isFlipedString1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder(s1);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(0);
            sb = sb.deleteCharAt(0);
            sb.append(c);
            if (Objects.equals(sb.toString(), s2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (Objects.equals(s1, s2)) {
            return true;
        }
        return (s2 + s2).contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(new Number01dot09().isFlipedString("a", "a"));
    }

}
