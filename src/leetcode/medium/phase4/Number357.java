package leetcode.medium.phase4;

import method.Classic;
import method.FindRule;

/**
 * @author qcy
 * @create 2021/04/17 21:04:31
 * 357. 计算各个位数不同的数字个数
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@FindRule
public class Number357 {

    //0 -> 1
    //1 -> 9
    //2 -> 9*9
    //3 -> 9*9*8
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10;
        int k = 9;
        int temp = 9;
        int min = Math.min(10, n);

        for (int i = 2; i <= min; i++) {
            temp = temp * k;
            k--;
            ans += temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Number357().countNumbersWithUniqueDigits(2));
    }

}
