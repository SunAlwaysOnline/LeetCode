package leetcode.easy.phase2;

import method.DoublePointer;
import method.StringOperation;

/**
 * @author qcy
 * @create 2021/03/20 19:07:35
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@StringOperation
@DoublePointer
public class Number125 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            int le = isEffective(l);
            if (le == 2) {
                left++;
                continue;
            }
            char r = s.charAt(right);
            int re = isEffective(r);
            if (re == 2) {
                right--;
                continue;
            }

            if (l == r || (le == re && Math.abs(l - r) == 'a' - 'A')) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;
    }

    //0代表是字母，1代表是数字，其他为2
    private int isEffective(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return 0;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return 0;
        }
        if (ch >= '0' && ch <= '9') {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new Number125().isPalindrome("0P"));
    }


}
