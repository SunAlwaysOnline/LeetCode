package leetcode.easy.phase11;

import datastructure.Array;

/**
 * @author qcy
 * @create 2021/02/05 16:12:24
 * 1085. 最小元素各数位之和
 *
 * 给你一个正整数的数组 A。
 *
 * 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
 *
 * 最后，假如 S 所得计算结果是 奇数 的请你返回 0，否则请返回 1。
 *
 *
 * 示例 1:
 *
 * 输入：[34,23,1,24,75,33,54,8]
 * 输出：0
 * 解释：
 * 最小元素为 1，该元素各个数位上的数字之和 S = 1，是奇数所以答案为 0。
 * 示例 2：
 *
 * 输入：[99,77,33,66,55]
 * 输出：1
 * 解释：
 * 最小元素为 33，该元素各个数位上的数字之和 S = 3 + 3 = 6，是偶数所以答案为 1。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
public class Number1085 {

    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
        }

        int sum = 0;
        while (min != 0) {
            sum += min % 10;
            min /= 10;
        }
        return 1 - sum & 1;
    }

    public static void main(String[] args) {
        int[] A = {99, 77, 33, 66, 55};
        System.out.println(new Number1085().sumOfDigits(A));
    }

}
