package interview.medium.phase16;

import method.Classic;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/04/05 21:38:41
 * 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number16dot26 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.replaceAll(" ", "");
        int i = 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<>();

        while (i < length) {
            char op = s.charAt(i);
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                i++;
            }
            int num = 0;
            while (i < length && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            switch (op) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
            }
            stack.push(num);
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Number16dot26().calculate("3+5 / 2"));
    }

}
