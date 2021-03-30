package leetcode.hard.phase3;

import method.Classic;
import method.FindRule;

/**
 * @author qcy
 * @create 2021/03/30 14:56:07
 * 233. 数字 1 的个数
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@FindRule
public class Number233 {

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

}
