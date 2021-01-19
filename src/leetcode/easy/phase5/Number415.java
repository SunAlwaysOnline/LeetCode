package leetcode.easy.phase5;

import method.Classic;
import method.StringOperation;

/**
 * @author qcy
 * @create 2021/01/19 09:25:27
 * 415. 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number415 {

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;

        int[] res = new int[Math.max(length1, length2) + 1];

        int index1 = length1 - 1;
        int index2 = length2 - 1;
        int resIndex = res.length - 1;

        while (index1 >= 0 && index2 >= 0) {
            res[resIndex--] = (int) chars1[index1--] - 48 + (int) chars2[index2--] - 48;
        }
        while (index1 >= 0) {
            res[resIndex--] = (int) chars1[index1--] - 48;
        }
        while (index2 >= 0) {
            res[resIndex--] = (int) chars2[index2--] - 48;
        }

        boolean carry = false;
        for (int i = res.length - 1; i >= 0; i--) {
            int bit = res[i];
            if (carry) {
                bit += 1;
            }
            if (bit > 9) {
                carry = true;
                bit %= 10;
            } else {
                carry = false;
            }
            res[i] = bit;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number415().addStrings("11", "999"));
    }

}
