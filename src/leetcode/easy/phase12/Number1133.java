package leetcode.easy.phase12;

import datastructure.Array;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/01/28 11:28:31
 * 1133. 最大唯一数
 *
 * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 *
 * 如果不存在这个只出现一次的整数，则返回 -1。
 *  
 *
 * 示例 1：
 *
 * 输入：[5,7,3,9,4,9,8,3,1]
 * 输出：8
 * 解释：
 * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
 * 示例 2：
 *
 * 输入：[9,9,8,8]
 * 输出：-1
 * 解释：
 * 数组中不存在仅出现一次的整数。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 2000
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-unique-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
public class Number1133 {

    public int largestUniqueNumber(int[] A) {
        Arrays.sort(A);

        int length = A.length;
        int pre = A[length - 1];
        int count = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] == pre) {
                count++;
            } else {
                if (count == 1) {
                    return pre;
                }
                pre = A[i];
                count = 1;
            }
        }
        return count == 1 ? pre : -1;
    }

    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(new Number1133().largestUniqueNumber(A));
    }

}
