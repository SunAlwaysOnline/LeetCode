package leetcode.easy.phase14;

import method.BitOperation;

/**
 * @author qcy
 * @create 2020/12/27 22:26:07
 * 1342. 将数字变成 0 的操作次数
 *
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 *
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 *
 * 输入：num = 123
 * 输出：12
 *  
 *
 * 提示：
 *
 * 0 <= num <= 10^6
 *
 */
public class Number1342 {

    @BitOperation
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 14;
        System.out.println(new Number1342().numberOfSteps(num));
    }

}
