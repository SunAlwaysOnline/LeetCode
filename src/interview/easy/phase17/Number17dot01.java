package interview.easy.phase17;

import method.BitOperation;
import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/01/12 10:04:48
 * 面试题 17.01. 不用加号的加法
 *
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-without-plus-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@BitOperation
@WaitForComplete
public class Number17dot01 {

    //9+13=21
    //1001
    //1101
    //不进位为0100,等于两者异或
    //进位为两者相与并左移一位
    //a+b=a^b+(a&b)<<1
    public int add(int a, int b) {
        while (b != 0) {
            int noCarry = a ^ b;
            int carry = (a & b) << 1;
            a = noCarry;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Number17dot01().add(9, 13));
    }

}
