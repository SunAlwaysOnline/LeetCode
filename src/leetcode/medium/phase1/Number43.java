package leetcode.medium.phase1;

import method.Classic;
import method.Maths;
import method.StringOperation;

/**
 * @author qcy
 * @create 2021/04/03 18:24:49
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
@Maths
public class Number43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int mul = a * b;
                mul += ans[i + j + 1];
                ans[i + j + 1] = mul % 10;
                ans[i + j] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number43().multiply("999", "999"));
    }

}
