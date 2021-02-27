package leetcode.easy.phase14;

import result.Tedious;

/**
 * @author qcy
 * @create 2021/02/23 10:43:41
 * 1304. 和为零的N个唯一整数
 *
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1304 {

    @Tedious
    public int[] sumZero1(int n) {
        int[] array = new int[n];
        if ((n & 1) == 0) {
            for (int i = 0; i < n; i++) {
                array[i] = i >= n / 2 ? i : -(n / 2 + i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i == (n - 1) / 2) {
                    array[i] = 0;
                    continue;
                }
                array[i] = i > (n - 1) / 2 ? i - 1 : -((n - 1) / 2 + i);
            }
        }
        return array;
    }

    public int[] sumZero(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n / 2; i++) {
            array[2 * i] = i + 1;
            array[2 * i + 1] = -(i + 1);
        }

        return array;
    }

    public static void main(String[] args) {
        for (int i : new Number1304().sumZero(8)) {
            System.out.println(i);
        }
    }

}
