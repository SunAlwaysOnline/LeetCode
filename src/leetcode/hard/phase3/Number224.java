package leetcode.hard.phase3;

import method.Classic;
import method.Design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/31 09:22:01
 * 224. 基本计算器
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Design
public class Number224 {

    public int calculate(String s) {
        //去除空格字符
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        if (s.charAt(0) == '-') {
            s = 0 + s;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push("(");
                continue;
            }
            if (ch == '+') {
                stack.push("+");
                continue;
            }
            if (ch == '-') {
                stack.push("-");
                continue;
            }
            if (isNum(ch)) {
                int num = 0;
                int j = i;
                while (j < s.length() && isNum(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                stack.push(String.valueOf(num));
                if (j > i + 1) {
                    i = j - 1;
                }
                continue;
            }
            //遇到了)
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                sb.insert(0, stack.pop());
            }
            if (!stack.isEmpty() && stack.peek().equals("(")) {
                stack.pop();
            }
            int result = cal(sb.toString());
            stack.push(String.valueOf(result));
        }

        StringBuilder leave = new StringBuilder();
        while (!stack.isEmpty()) {
            leave.insert(0, stack.pop());
        }

        return cal(leave.toString());
    }

    private int cal(String s) {
        s = s.replaceAll("--", "+");

        if (s.length() == 0) {
            return 0;
        }
        if (!s.contains("+") && !s.contains("-")) {
            return Integer.parseInt(s);
        }
        if (s.charAt(0) == '+') {
            return cal(s.substring(1));
        }
        if (s.charAt(0) == '-') {
            StringBuilder temp = new StringBuilder();
            int index = 1;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                temp.append(s.charAt(index));
                index++;
            }
            return -Integer.parseInt(temp.toString()) + cal(s.substring(index));
        }
        StringBuilder first = new StringBuilder();
        int index = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            first.append(s.charAt(index));
            index++;
        }
        int a = Integer.parseInt(first.toString());

        char symbol = s.charAt(index);
        index++;

        StringBuilder second = new StringBuilder();
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            second.append(s.charAt(index));
            index++;
        }
        int b = 0;
        if (second.length() != 0) {
            b = Integer.parseInt(second.toString());
        }

        int result = 0;
        if (symbol == '+') {
            result = a + b;
        } else {
            result = a - b;
        }

        return result + cal(s.substring(index));
    }

    public boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    //-------------------------------------------
    public int calculate1(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Number224().calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
    }

}
