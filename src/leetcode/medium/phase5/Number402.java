package leetcode.medium.phase5;

import method.Classic;
import method.Greedy;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/04 10:11:29
 * 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Greedy
public class Number402 {

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && ch == '0') {
                continue;
            }
            stack.push(ch);
        }

        while (k-- > 0) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number402().removeKdigits("1432219", 3));
    }

}
