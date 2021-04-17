package jzoffer.medium.phase1;

import method.Classic;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/04/17 21:32:48
 * 剑指 Offer 66. 构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number66 {

    public int[] constructArr(int[] a) {
        int length = a.length;
        int[] ans = new int[length];

        int temp = 1;
        for (int i = 0; i < length; i++) {
            ans[i] = temp;
            temp *= a[i];
        }

        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] *= temp;
            temp *= a[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new Number66().constructArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(arr));
    }

}
