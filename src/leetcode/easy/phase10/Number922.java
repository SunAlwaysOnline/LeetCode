package leetcode.easy.phase10;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DoublePointer;
import method.Optimal;
import method.Orignal;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/11/12 10:39:38
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 */
public class Number922 {

    @Orignal
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public int[] sortArrayByParityII1(int[] A) {
        int[] res = new int[A.length];
        int oddIndex = 1;
        int evenIndex = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                res[oddIndex] = A[i];
                oddIndex += 2;
            } else {
                res[evenIndex] = A[i];
                evenIndex += 2;
            }
        }
        return res;
    }

    @DoublePointer
    @Optimal
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int left = 0;
        int right = length - 1;
        while (true) {
            //从左边找第一个放错位置的奇数
            while (left <= length - 1) {
                if (!isOdd(left) && isOdd(A[left])) {
                    break;
                }
                left++;
            }

            //从右边找第一个放错位置的偶数
            while (right >= 0) {
                if (isOdd(right) && !isOdd(A[right])) {
                    break;
                }
                right--;
            }

            if (left == length || right == -1) {
                break;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        Arrays.stream(new Number922().sortArrayByParityII(A)).forEach(System.out::println);
    }

}
