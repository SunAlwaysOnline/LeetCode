package leetcode.easy.phase5;

import method.BitOperation;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/04 15:32:48
 * 476. 数字的补数
 *
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2:
 *
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 注意:
 *
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 */
@Classic
@BitOperation
public class Number476 {

    //101(5)^111=010(5的补数)
    public int findComplement(int num) {
        int record = num;
        int allOneNum = 1;

        while (record != 0) {
            record = record >> 1;
            allOneNum = allOneNum << 1;
        }
        return (allOneNum - 1) ^ num;
    }

    public static void main(String[] args) {
        System.out.println(new Number476().findComplement(5));
    }

}
