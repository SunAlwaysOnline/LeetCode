package leetcode.easy.phase1;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/10/062 22:08:10
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class Number20 {

    //利用栈
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if ((peek == '(' && temp == ')') || (peek == '[' && temp == ']') || (peek == '{' && temp == '}')) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            } else {
                stack.push(temp);
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number20().isValid("([]])"));
    }
}
