package interview.easy.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.DoublePointer;
import method.Optimal;
import method.Orignal;
import method.Sort;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/11/10 10:15:25
 * 面试题 10.01. 合并排序的数组
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 *
 */
public class Number10dot01 {

    @Orignal
    @Sort
    @TimeComplexity("O((m+n)log(m+n))")
    @SpaceComplexity("O(log(m+n))")
    public void merge1(int[] A, int m, int[] B, int n) {
        for (int i = m; i < m + n; i++) {
            A[i] = B[i - m];
        }
        Arrays.sort(A, 0, m + n);
    }

    @DoublePointer
    @TimeComplexity("O(m+n)")
    @SpaceComplexity("O(m+n)")
    public void merge2(int[] A, int m, int[] B, int n) {
        int[] res = new int[m + n];
        int a = 0;
        int b = 0;
        int index = 0;

        while (a < m && b < n) {
            if (A[a] < B[b]) {
                res[index++] = A[a++];
            } else {
                res[index++] = B[b++];
            }
        }
        while (b < n) {
            res[index++] = B[b++];
        }
        while (a < m) {
            res[index++] = A[a++];
        }

        for (int i = 0; i < m + n; i++) {
            A[i] = res[i];
        }
    }

    @Optimal
    @TimeComplexity("O(m+n)")
    @SpaceComplexity("O(1)")
    public void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int index = m + n - 1;

        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[index--] = A[a--];
            } else {
                A[index--] = B[b--];
            }
        }

        while (a >= 0) {
            A[index--] = A[a--];
        }
        while (b >= 0) {
            A[index--] = B[b--];
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 7, 0, 0, 0, 0};
        int[] B = {1, 3, 4};
        new Number10dot01().merge(A, 3, B, B.length);
        Arrays.stream(A).forEach(System.out::println);
    }

}
