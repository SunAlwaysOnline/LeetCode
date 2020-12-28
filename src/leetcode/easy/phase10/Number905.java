package leetcode.easy.phase10;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;
import method.DoublePointer;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/12/28 16:53:44
 * 905. 按奇偶排序数组
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * 
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 */
@Classic
@Array
public class Number905 {

    @DoublePointer
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 1) {
            return A;
        }

        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            //从左到右找到第一个奇数
            while ((A[left] & 1) == 0 && left < A.length - 1) {
                left++;
            }
            while ((A[right] & 1) == 1 && right > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            //交换
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 0, 2};
        Arrays.stream(new Number905().sortArrayByParity(A)).forEach(System.out::println);
    }
}
