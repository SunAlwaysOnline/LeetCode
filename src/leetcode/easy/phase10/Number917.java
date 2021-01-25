package leetcode.easy.phase10;

import method.Classic;
import method.StringOperation;

import java.util.function.Predicate;

/**
 * @author qcy
 * @create 2021/01/25 15:11:26
 * 917. 仅仅反转字母
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number917 {

    public String reverseOnlyLetters(String S) {
        int left = 0;
        int rigth = S.length() - 1;
        char[] chars = S.toCharArray();
        Predicate<Integer> predicate = val -> val < 65 || (val > 90 && val < 97);
        while (left < rigth) {
            while (left < rigth && predicate.test((int) chars[left])) {
                left++;
            }
            while (left < rigth && predicate.test((int) chars[rigth])) {
                rigth--;
            }
            if (left < rigth) {
                char temp = chars[left];
                chars[left] = chars[rigth];
                chars[rigth] = temp;

                left++;
                rigth--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        //输入："a-bC-dEf-ghIj"
        //输出："j-Ih-gfE-dCba"
        System.out.println(new Number917().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println((int) 'Z');//65-90
        System.out.println((int) 'z');//97-122
    }

}
