package leetcode.easy.phase1;

/**
 * @author qcy
 * @create 2020/10/07 22:08:38
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class Number9 {

    //将整数转为字符串
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            if (charArray[i] != charArray[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    //取后一半数字与前一半数字进行比较
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x = x / 10;
        }

        return x == half || x == half / 10;
    }

}
