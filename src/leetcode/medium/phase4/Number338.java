package leetcode.medium.phase4;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DP;
import method.Optimal;
import method.Orignal;
import method.Violence;

/**
 * @author qcy
 * @create 2020/12/11 10:20:20
 * 338. 比特位计数
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class Number338 {

    static class Solution1 {
        @Orignal
        @Violence
        @SpaceComplexity("O(n)")
        @TimeComplexity("O(n*sizeOf(num))")
        public int[] countBits(int num) {
            int[] array = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                array[i] = bit(i);
            }
            return array;
        }

        private int bit(int num) {
            int res = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    res++;
                }
                num = num >> 1;
            }
            return res;
        }

    }

    static class Solution2 {
        @DP
        @Optimal
        @SpaceComplexity("O(n)")
        @TimeComplexity("O(n)")
        public int[] countBits(int num) {
            int[] array = new int[num + 1];
            array[0] = 0;
            for (int i = 1; i <= num; i++) {
                if ((i & 1) == 1) {
                    array[i] = array[i - 1] + 1;
                } else {
                    array[i] = array[i / 2];
                }
            }
            return array;
        }

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.bit(0));
    }

}
