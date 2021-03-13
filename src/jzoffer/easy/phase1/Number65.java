package jzoffer.easy.phase1;

import method.BitOperation;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/07 22:52:15
 * 剑指 Offer 65. 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * 通过次数38,355提交次数66,431
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BitOperation
public class Number65 {

    //a+b=a^b+(a&b)<<1 +号代表异或值与移位值再进行相同的步骤
    public int add(int a, int b) {
        while (b != 0) {
            //无进位和
            int sum = a ^ b; //1101^1001=0100
            //进位
            int carry = (a & b) << 1; //1101&1001=1001 1001<<1=10010
            //再进行相同的步骤
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Number65().add(13, 9));
    }

}
