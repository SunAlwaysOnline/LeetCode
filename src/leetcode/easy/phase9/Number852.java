package leetcode.easy.phase9;

/**
 * @author qcy
 * @create 2020/11/04 16:03:22
 * 852. 山脉数组的峰顶索引
 *
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * 
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *  
 */
public class Number852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        while (arr[left] < arr[left + 1]) {
            left++;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println(new Number852().peakIndexInMountainArray(arr));
    }

}
