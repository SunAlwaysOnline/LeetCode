package leetcode.medium.phase4;

import method.Classic;
import method.Maths;
import method.Mem;
import method.Violence;

/**
 * @author qcy
 * @create 2021/04/13 16:06:29
 * 343. 整数拆分
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Maths
public class Number343 {

    @Maths
    public int integerBreak1(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        return (int) (Math.pow(3, a) * 2);
    }

    //------------------------------------
    int ans2 = 1;

    @Violence
    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }

        for (int i = 1; i <= n; i++) {
            ans2 = Math.max(ans2, Math.max(i * (n - i), i * integerBreak2(n - i)));
        }

        return ans2;
    }

    //------------------------------------
    int[] mem;

    @Mem
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        mem = new int[n + 1];
        dfs(n);
        return mem[n];
    }

    private int dfs(int n) {
        if (n <= 3) {
            mem[n] = n - 1;
            return n - 1;
        }
        if (mem[n] != 0) {
            return mem[n];
        }

        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * dfs(n - i)));
        }

        mem[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Number343().integerBreak(5));
    }

}
