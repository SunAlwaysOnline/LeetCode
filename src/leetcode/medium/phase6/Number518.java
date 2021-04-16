package leetcode.medium.phase6;

import method.Classic;
import method.PermutationAndCombination;
import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/04/16 13:52:56
 */
@Classic
@PermutationAndCombination
@WaitForComplete
public class Number518 {

    //输入: amount = 5, coins = [1, 2, 5]
    //输出: 4
    //解释: 有四种方式可以凑成总金额:
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/coin-change-2
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int change(int amount, int[] coins) {
        if (amount <= 0) {
            return 0;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Number518().change(5, new int[]{1, 2, 5}));
    }

}
