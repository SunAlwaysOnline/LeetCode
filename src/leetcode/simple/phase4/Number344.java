package leetcode.simple.phase4;

import java.util.stream.Stream;

/**
 * @author qcy
 * @create 2020/10/08 21:15:10
 * 344. 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 */

public class Number344 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }

        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            if (s[i] == s[length - i - 1]) {
                continue;
            }
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Number344().reverseString(s);
        Stream.of(s).forEach(System.out::print);
    }

}
