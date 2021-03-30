package jzoffer.hard.phase1;

import method.Classic;
import method.FindRule;

/**
 * @author qcy
 * @create 2021/03/30 14:24:42
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *  
 *
 * 限制：
 *
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@FindRule
public class Number43 {

    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        String nStr = String.valueOf(n);
        //最高位
        int high = nStr.charAt(0) - '0';
        //最高位的阶数
        int pow = (int) Math.pow(10, nStr.length() - 1);
        //不包含最高位的数
        int last = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number43().countDigitOne(12));
    }
}
