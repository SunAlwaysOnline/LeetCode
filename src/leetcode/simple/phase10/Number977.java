package leetcode.simple.phase10;

import method.DoublePointer;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/10/16 11:27:23
 * 977. 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 */
public class Number977 implements DoublePointer {

    public int[] sortedSquares1(int[] A) {
        if (A == null) {
            return null;
        }

        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);

        return result;
    }

    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }

        int[] result = new int[A.length];
        int i = 0, j = A.length - 1, index = A.length - 1;
        while (i <= j) {
            if (A[i] + A[j] < 0) {
                result[index--] = A[i] * A[i];
                i++;
            } else {
                result[index--] = A[j] * A[j];
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        Arrays.stream(new Number977().sortedSquares(A)).forEach(System.out::println);
    }
}
