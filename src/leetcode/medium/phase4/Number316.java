package leetcode.medium.phase4;

import datastructure.Array;
import method.Classic;
import method.Greedy;
import method.MonotonousStack;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/04 10:35:53
 * 316. 去除重复字母
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@Greedy
@MonotonousStack
public class Number316 {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            count[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {

            count[ch - 'a']--;
            if (inStack[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                inStack[stack.peek() - 'a'] = false;
                stack.pop();
            }
            inStack[ch - 'a'] = true;
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number316().removeDuplicateLetters("bbcaac"));
    }

}
